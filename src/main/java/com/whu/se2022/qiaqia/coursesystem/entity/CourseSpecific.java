package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

/**
 * 课程信息。为具体课程的信息。
 */
@Data
public class CourseSpecific {
    private Long id;
    private Long courseCommonId;
    private CourseCommon courseCommon;
    private Long teacherId;
    private String location;
    private int quota;
    private int quotaUsed;
    private Long semesterId;
}
