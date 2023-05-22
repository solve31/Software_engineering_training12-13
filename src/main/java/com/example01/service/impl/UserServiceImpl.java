package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.User;
import com.example01.mapper.UserMapper;
import com.example01.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
