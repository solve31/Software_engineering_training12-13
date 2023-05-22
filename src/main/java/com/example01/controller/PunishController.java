package com.example01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example01.entity.Award;
import com.example01.entity.Punish;
import com.example01.service.AwardService;
import com.example01.service.PunishService;
import com.example01.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/punish")
public class PunishController {
    @Autowired
    private PunishService punishService;

    @GetMapping("/list/{current}/{pageSize}")
    public R getPage(@PathVariable int current, @PathVariable int pageSize){
        Page<Punish> page1=new Page<>(current,pageSize);
        Page<Punish> punishPage = punishService.page(page1, null);
        return new R(20000,"成功",punishPage);
    }
    @PostMapping("/add")
    public R add(@RequestBody Punish punish){
        boolean save = punishService.save(punish);
        if(save==false) return new R().renderError("添加失败");
        return new R().renderSuccess("添加成功");
    }
    @PostMapping("/update")
    public R update(@RequestBody Punish punish){
        boolean save = punishService.updateById(punish);
        if(save==false) return new R().renderError("修改失败");
        return new R().renderSuccess("修改成功");
    }
    @DeleteMapping("/del/{id}")
    public R delete(@PathVariable Long id){
        boolean save = punishService.removeById(id);
        if(save==false) return new R().renderError("失败");
        return new R().renderSuccess("成功");
    }
}
