package com.example01.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example01.entity.Student;
import com.example01.service.StudentService;
import com.example01.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("/list/{current}/{pageSize}")
    public R page(@PathVariable int current, @PathVariable int pageSize){
        Page<Student> studentPage=studentService.getPage(current,pageSize);
        R r=new R(20000,"成功",studentPage);
        return r;
    }
    @PostMapping("/add")
    public R add(@RequestBody Student student){
        boolean i=studentService.save(student);
        if(i==false) return new R().renderError("添加失败");
        return new R().renderSuccess("添加成功");
    }
    @PostMapping("/edit")
    public R edit(@RequestBody Student student){
        boolean i=studentService.updateById(student);
        if(i==false) return new R().renderError("编辑失败");
        return new R().renderSuccess("编辑成功");
    }
    @GetMapping("/del/{id}")
    public R delete(@PathVariable Long id){
        boolean i=studentService.removeById(id);
        if(i==false) return new R().renderError("删除失败");
        return new R().renderSuccess("删除成功");
    }
}
