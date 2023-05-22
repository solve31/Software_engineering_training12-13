package com.example01.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Course;
import com.example01.entity.Score;
import com.example01.entity.ScoreDto;
import com.example01.mapper.ScoreMapper;
import com.example01.service.CourseService;
import com.example01.service.ScoreService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score> implements ScoreService {
    @Autowired
    private CourseService courseService;
    @Override
    public Page<ScoreDto> getList(int current, int pageSize) {
        Page<Score> page1=new Page<>(current,pageSize);
        Page<Score> scorePage = this.page(page1, null);
        Page<ScoreDto> page2=new Page<>();
        BeanUtils.copyProperties(page1,page2);
        List<Score> records = scorePage.getRecords();
        List<ScoreDto> scoreDtoList=records.stream().map((item)->{
            String cno=item.getCno();
            ScoreDto scoreDto=new ScoreDto();
            BeanUtils.copyProperties(item,scoreDto);
            LambdaQueryWrapper<Course> queryWrapper=new LambdaQueryWrapper<>();
            queryWrapper.eq(cno!=null,Course::getCno,cno);
            List<Course> list = courseService.list(queryWrapper);
            Course course = list.get(0);
            if(course!=null){
                scoreDto.setCname(course.getCname());
                scoreDto.setType(course.getType());
                scoreDto.setSc(course.getSc());
            }
            return scoreDto;
        }).collect(Collectors.toList());
        page2.setRecords(scoreDtoList);
        return page2;
    }
}
