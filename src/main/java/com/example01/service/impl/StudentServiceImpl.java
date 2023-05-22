package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Student;
import com.example01.mapper.StudentMapper;
import com.example01.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>implements StudentService {

    @Override
    public Page<Student> getPage(Integer current, Integer pageSize) {
        Page<Student> page=new Page<>(current,pageSize);

        return this.page(page,null);
    }
}
