package com.whu.se2022.qiaqia.coursesystem.dto.response;

import com.whu.se2022.qiaqia.coursesystem.entity.College;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserInfoData {
    College college;
    String createdAt;
    String updateAt;
    int entranceYear;
    Long id;
    String realName;
    int role;
    String username;
}
