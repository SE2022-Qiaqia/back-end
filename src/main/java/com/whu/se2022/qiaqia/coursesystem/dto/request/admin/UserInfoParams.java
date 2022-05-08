package com.whu.se2022.qiaqia.coursesystem.dto.request.admin;

import lombok.Data;

@Data
public class UserInfoParams {

    private Long id;
    private String username;
    private String password;
    private Long collegeId;
    private int entranceYear;

}
