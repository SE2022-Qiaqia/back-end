package com.whu.se2022.qiaqia.coursesystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import com.whu.se2022.qiaqia.coursesystem.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){return courseService.getCourseById(id);}


    //获取可选课头列表
    @GetMapping("/course/valid")
    public List<CourseHead> getValidCourse(){return courseService.getValidCourse();}

    //更新课程信息
    @PostMapping("/course")
    public boolean updateCourse(@RequestBody JSONObject jsonObject){
        try{
            return courseService.updateCourse(jsonObject.getString("courseName"),
                    jsonObject.getInteger("credit"),
                    jsonObject.getInteger("courseHour"),
                    jsonObject.getLong("instituteId"),
                    jsonObject.getLong("courseId"));
        }catch (Exception e){
            log.info(e.getMessage());
            return false;
        }
    }


    //添加课程
    @PutMapping("/course")
    public boolean putCourse(@RequestBody JSONObject jsonObject){

    }
}
