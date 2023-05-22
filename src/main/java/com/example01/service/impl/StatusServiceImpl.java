package com.example01.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example01.entity.Status;
import com.example01.mapper.StatusMapper;
import com.example01.service.StatusService;
import org.springframework.stereotype.Service;

@Service
public class StatusServiceImpl extends ServiceImpl<StatusMapper, Status> implements StatusService {
}
