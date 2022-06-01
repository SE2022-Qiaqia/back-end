package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String username;
    private String realname;
    private String password;
    // 0    学生
    // 100  教师
    // 200  管理员
    private int role;
    private Long collegeId;
    private int entranceYear;
    private String createdAt;
    private String updatedAt;
}
