package com.example01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example01.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
