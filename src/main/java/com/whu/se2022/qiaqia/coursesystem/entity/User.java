package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String username;
    private String password;
    private Long collegeId;
    private int entranceYear;
}