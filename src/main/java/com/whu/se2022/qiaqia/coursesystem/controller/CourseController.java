package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){return courseService.getCourseById(id);}

}
