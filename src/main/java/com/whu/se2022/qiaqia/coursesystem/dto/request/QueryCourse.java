package com.whu.se2022.qiaqia.coursesystem.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class QueryCourse {
    private String name;
    private boolean hasQuota;
    private Long semesterId;
    private String teacherName;
    private List<Long> collegesId;
}
