package com.whu.se2022.qiaqia.coursesystem.dto.request;

import java.util.List;

public class GetUserListParam {
    List<Integer> collegesId;
    int entranceYearFrom;
    int entranceYearTo;
    Long id;
    int page;
    String realName;
    List<Integer> roles;
    int size;
    String username;
}
