package com.example01.entity;

import lombok.Data;

@Data
public class Course {
    private Long id;
    private String cno;
    private String cname;
    private String type;
    private int sc;
}
