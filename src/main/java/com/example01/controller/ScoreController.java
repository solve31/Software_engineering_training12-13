package com.example01.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example01.entity.Course;
import com.example01.entity.Score;
import com.example01.entity.ScoreDto;
import com.example01.service.CourseService;
import com.example01.service.ScoreService;
import com.example01.utils.R;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;
    @Autowired
    public CourseService courseService;

    @GetMapping("/list/{current}/{pageSize}")
    public R getPage(@PathVariable int current,@PathVariable int pageSize){
        Page<ScoreDto> page2=scoreService.getList(current,pageSize);
        return new R(20000,"成功",page2);
    }
    @PostMapping("/add")
    public R add(@RequestBody Score score){
        boolean i=scoreService.save(score);
        if(i==false) return new R().renderError("添加失败");
        return new R().renderSuccess("添加成功");
    }
    @PostMapping("/update")
    public R update(@RequestBody Score score){
        boolean i=scoreService.updateById(score);
        if(i==false) return new R().renderError("编辑失败");
        return new R().renderSuccess("编辑成功");
    }
    @DeleteMapping("/del/{id}")
    public R delete(@PathVariable Long id){
        boolean i=scoreService.removeById(id);
        if(i==false) return new R().renderError("删除失败");
        return new R().renderSuccess("删除成功");
    }
}
