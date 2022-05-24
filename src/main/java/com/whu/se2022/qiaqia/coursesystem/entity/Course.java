package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    private Long courseId;
    private String courseName;
    private Long instituteId;
    private Float courseHour;
    private Float credit;
}
