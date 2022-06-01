package com.whu.se2022.qiaqia.coursesystem.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUserListData {
    List<GetUserInfoData> content;
    int pageNo;
    int pageSize;
    int total;
}

