package com.whu.se2022.qiaqia.coursesystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserInfoParam {
    Long collegeId;
    int entranceYear;
    String realName;
    int role;
    String username;
}
