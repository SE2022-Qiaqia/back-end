package com.whu.se2022.qiaqia.coursesystem.entity;

import lombok.Data;

/**
 * 学院信息。
 */
@Data
public class College {
    private Long collegeId;
    private String name;
    private String createdAt;
    private String updatedAt;
}