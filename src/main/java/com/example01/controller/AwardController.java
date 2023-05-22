package com.example01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example01.entity.Award;
import com.example01.entity.Score;
import com.example01.entity.ScoreDto;
import com.example01.service.AwardService;
import com.example01.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/award")
public class AwardController {
    @Autowired
    private AwardService awardService;

    @GetMapping("/list/{current}/{pageSize}")
    public R getPage(@PathVariable int current, @PathVariable int pageSize){
        Page<Award> page1=new Page<>(current,pageSize);
        Page<Award> awardPage = awardService.page(page1, null);

        return new R(20000,"成功",awardPage);
    }
    @PostMapping("/add")
    public R add(@RequestBody Award award){
        boolean save = awardService.save(award);
        if(save==false) return new R().renderError("添加失败");
        return new R().renderSuccess("添加成功");
    }
    @PostMapping("/update")
    public R update(@RequestBody Award award){
        boolean save = awardService.updateById(award);
        if(save==false) return new R().renderError("修改失败");
        return new R().renderSuccess("修改成功");
    }
    @DeleteMapping("/del/{id}")
    public R delete(@PathVariable Long id){
        boolean save = awardService.removeById(id);
        if(save==false) return new R().renderError("失败");
        return new R().renderSuccess("成功");
    }
}
