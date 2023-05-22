package com.example01.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example01.entity.Student;

public interface StudentService extends IService<Student> {
    public Page<Student> getPage(Integer current,Integer pageSize);
}
