package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

/**
 * 用户(教师/学生)课程信息。
 */
@Data
public class UserCourse {
    private Long id;
    private Long studentId;
    private Long courseSpecificId;
    private float scores;
}
