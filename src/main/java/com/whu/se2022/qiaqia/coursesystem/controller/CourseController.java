package com.whu.se2022.qiaqia.coursesystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.CourseService;
import com.whu.se2022.qiaqia.coursesystem.util.ResponseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    CourseService courseService;


    @GetMapping("/course/{id}")
    public Course getCourseById(@PathVariable Long id){return courseService.getCourseById(id);}


    //获取可选课头列表
    @GetMapping("/course/valid")
    public ResponseRes<List<CourseHead>> getValidCourse(){
        return new ResponseRes<>(courseService.getValidCourse());
    }

    //更新课程信息
    @PostMapping("/course")
    public ResponseRes<Boolean> updateCourse(@RequestBody JSONObject jsonObject){
        try{
            courseService.updateCourse(jsonObject.getString("courseName"),
                    jsonObject.getInteger("credit"),
                    jsonObject.getInteger("courseHour"),
                    jsonObject.getLong("instituteId"),
                    jsonObject.getLong("courseId"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501, e.getMessage(), false);
        }
    }


    //添加课程
    @PutMapping("/course")
    public ResponseRes<Boolean> putCourse(@RequestBody JSONObject jsonObject){
        try {
            courseService.insertCourse(jsonObject.getString("courseName"),
                    jsonObject.getInteger("credit"),
                    jsonObject.getInteger("courseHour"),
                    jsonObject.getLong("instituteId"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }

    //添加课头
    @PutMapping("/course/head")
    public ResponseRes<Boolean> putCourseHead(@RequestBody JSONObject jsonObject){
        try {
            String headWeekDay = jsonObject.getString("headTime").substring(2,3);
            String headClassNum = jsonObject.getString("headTime").split(" {2}")[1].substring(0,3);
            courseService.insertCourseHead(jsonObject.getLong("teacherId"),
                    "#"+headWeekDay+"("+headClassNum+")",
                    jsonObject.getString("headAddress"),
                    jsonObject.getLong("courseId"),
                    jsonObject.getInteger("headYear"),
                    jsonObject.getInteger("volume"),
                    jsonObject.getInteger("term"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }

    //更新课头信息
    @PostMapping("/course/head")
    public ResponseRes<Boolean> updateCourseHead(@RequestBody JSONObject jsonObject){
        try {
            String headWeekDay = jsonObject.getString("headTime").substring(2,3);
            String headClassNum = jsonObject.getString("headTime").split(" {2}")[1].substring(0,3);
            courseService.updateCourseHead(jsonObject.getLong("teacherId"),
                    "#"+headWeekDay+"("+headClassNum+")",
                    jsonObject.getString("headAddress"),
                    jsonObject.getLong("courseId"),
                    jsonObject.getInteger("headYear"),
                    jsonObject.getInteger("volume"),
                    jsonObject.getInteger("volumeLeft"),
                    jsonObject.getInteger("term"),
                    jsonObject.getLong("headId"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }

    //查询某学生课程表
    @GetMapping("/course/valid/{id}")
    public ResponseRes<List<CourseHead>> getCourseOfStu(@PathVariable Long id){
        try {
            return new ResponseRes<>(courseService.getCourseOfStu(id));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501,e.getMessage(),new LinkedList<>());
        }


    }

    //查询课头内学生
    @GetMapping("/course/student/{id}")
    public ResponseRes<List<User>> getStudentOfCourse(@PathVariable Long id){
        try{
            return new ResponseRes<>(courseService.getStudentOfCourse(id));
        }catch (Exception e){
            log.info(e.getMessage());
            return new ResponseRes<>(501,e.getMessage(),new LinkedList<>());
        }
    }

    //强制选课
    @PostMapping("/course/forcecheck")
    public ResponseRes<Boolean> postForceCheckHeadStu(@RequestBody JSONObject jsonObject){
        try {
            courseService.forceCheck(jsonObject.getLong("studentId"),
                    jsonObject.getLong("head_id"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }

    // 强制撤课
    @PostMapping("/course/forceuncheck")
    public ResponseRes<Boolean> postForceUncheckHeadStu(@RequestBody JSONObject jsonObject){
        try {
            return new ResponseRes<>(true);
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }

    //学生选课
    @PostMapping("/course/check")
    public ResponseRes<Boolean> postCheckHeadStu(@RequestBody JSONObject jsonObject){
        try {
            return new ResponseRes<>(true);
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }


    //学生撤课
    @PostMapping("/course/uncheck")
    public ResponseRes<Boolean> postUncheckHeadStu(@RequestBody JSONObject jsonObject){
        try {
            return new ResponseRes<>(true);
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }
}
