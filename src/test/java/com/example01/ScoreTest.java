package com.example01;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example01.entity.ScoreDto;
import com.example01.service.ScoreService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@Slf4j
@SpringBootTest
public class ScoreTest {
    @Autowired
    private ScoreService scoreService;

    @Test
    public void test1(){
        Page<ScoreDto> list = scoreService.getList(1, 5);
        List<ScoreDto> records =list.getRecords();
        for (int i=0;i<records.size();i++){
            ScoreDto scoreDto=records.get(i);
            //System.out.print("学号"+scoreDto.getSno()+"姓名"+scoreDto.getName()+"成绩"+scoreDto.getGrade());
            //System.out.println(scoreDto.toString());
            log.info("{}",scoreDto);
        }
    }
    public void test2(){

    }
}
