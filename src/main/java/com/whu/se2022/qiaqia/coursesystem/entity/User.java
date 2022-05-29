package com.whu.se2022.qiaqia.coursesystem.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userId;
    private String name;
    private Integer role;
    private Date rollDate;
    private String password;
    private Integer instituteId;
    private String instituteName;
}
