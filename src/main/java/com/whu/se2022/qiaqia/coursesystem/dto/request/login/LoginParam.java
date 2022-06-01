package com.whu.se2022.qiaqia.coursesystem.dto.request.login;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginParam {
    Long id;
    String password;
}
