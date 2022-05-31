package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseHead {
    private Long headId;
    private Long teacherId;
    private String headTime;
    private String headAddress;
    private Long courseId;
    private Integer headYear;
    private Integer volume;
    private Integer volumeLeft;
    private Integer headTerm;
    private String courseName;
    private Integer credit;
    private Integer courseHour;
    private String name;
    private String instituteName;
}
