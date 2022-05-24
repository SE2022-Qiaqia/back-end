package com.whu.se2022.qiaqia.coursesystem.service;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.mapper.CourseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    CourseMapper courseMapper;


    public Course getCourseById(Long id){return courseMapper.getCourseById(id);}
}
