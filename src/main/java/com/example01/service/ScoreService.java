package com.example01.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example01.entity.Score;
import com.example01.entity.ScoreDto;

public interface ScoreService extends IService<Score> {
    public Page<ScoreDto> getList(int current,int pageSize);
}
