package com.example01.entity;

import lombok.Data;

@Data
public class Student {
    private Long id;
    private String sno;
    private String name;
    private String gender;
    private int age;
    private String college;//学院
    private String grade;//年级
    private String speciality;//专业
    private int classroom;//班级

}
