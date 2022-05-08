package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

/**
 * 课程公共信息。
 */
@Data
public class CourseCommon {

    private Long id;
    private String name;
    private float credits;
    private int hours;
    private Long collegeId;

}
