package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Award;
import com.example01.mapper.AwardMapper;
import com.example01.service.AwardService;
import org.springframework.stereotype.Service;

@Service
public class AwardServiceImpl extends ServiceImpl<AwardMapper, Award> implements AwardService {
}
