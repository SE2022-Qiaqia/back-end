package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

/**
 * 课头上课时间。
 */
@Data
public class CourseSchedule {
    private Long id;
    private int dayOfWeek;
    private int hoursId;
    private Long courseSpecificId;
}
