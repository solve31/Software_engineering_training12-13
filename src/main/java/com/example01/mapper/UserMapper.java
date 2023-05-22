package com.example01.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example01.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
