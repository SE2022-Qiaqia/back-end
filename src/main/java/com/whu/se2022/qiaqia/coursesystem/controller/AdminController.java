package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.request.admin.UserInfoParams;
import com.whu.se2022.qiaqia.coursesystem.dto.response.None;
import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseCommon;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseSpecific;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('admin')")
public class AdminController {

    @PostMapping("/user")
    public Response<None> addUser(@RequestBody UserInfoParams userInfoParams) {
        // TODO
        return null;
    }

    @DeleteMapping("/user/{id}")
    public Response<None> deleteUser(@PathVariable("id") long userId) {
        // TODO
        return null;
    }

    @PutMapping("/user/{id}")
    public Response<None> updateUser(@PathVariable("id") long userId,
                                     @RequestBody UserInfoParams userInfoParams) {
        // TODO
        return null;
    }

    @GetMapping("/user/{id}/courses")
    public Response<List<CourseSpecific>> getCoursesForUser(@PathVariable("id") String id) {
        // TODO
        return null;
    }

    @GetMapping("/user/list")
    public Response<List<User>> getUsers(@RequestBody User queryCondition) {
        // TODO
        return null;
    }

    @PostMapping("/college")
    public Response<Long> addCollege(@RequestParam("collegeName") String collegeName) {
        // TODO
        return null;
    }

    @DeleteMapping("/college/{id}")
    public Response<None> deleteCollege(@PathVariable("id") long collegeId) {
        // TODO
        return null;
    }

    @PostMapping("/course_common")
    public Response<None> addCourseCommon(@RequestBody CourseCommon courseCommon) {
        // TODO
        return null;
    }

    @PutMapping("/course_common/{id}")
    public Response<None> updateCourseCommon(@RequestBody CourseCommon courseCommon,
                                             @PathVariable("id") int courseCommonId) {
        // TODO
        return null;
    }

    @PostMapping("/course")
    public Response<None> addCourseSpecific(@RequestBody CourseSpecific courseSpecific) {
        // TODO
        return null;
    }

    @PutMapping("/course/{id}")
    public Response<None> updateCourseSpecific(@RequestBody CourseSpecific courseSpecific,
                                               @PathVariable("id") int courseSpecificId) {
        // TODO
        return null;
    }

    @PostMapping("/course/{courseId}/{studentId}")
    public Response<Boolean> addStudentToCourse(@PathVariable("courseId") long courseSpecificId,
                                                @PathVariable("studentId") long studentId) {
        // TODO
        return null;
    }

    @DeleteMapping("/course/{courseId}/{studentId}")
    public Response<None> dropCourseForStudent(@PathVariable("courseId") long courseSpecificId,
                                               @PathVariable("studentId") long studentId) {
        // TODO
        return null;
    }

}