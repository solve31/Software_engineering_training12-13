package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Punish;
import com.example01.mapper.PunishMapper;
import com.example01.service.PunishService;
import org.springframework.stereotype.Service;

@Service
public class PunishServiceImpl extends ServiceImpl<PunishMapper, Punish> implements PunishService {
}
