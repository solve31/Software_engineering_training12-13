package com.example01.entity;

import lombok.Data;

@Data
public class ScoreDto extends Score{
    private String cname;
    private String type;
    private int sc;

}
