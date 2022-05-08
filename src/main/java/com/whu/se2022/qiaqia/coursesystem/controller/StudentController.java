package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.response.None;
import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseSpecific;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
@PreAuthorize("hasRole('student')")
public class StudentController {

    @PostMapping("/course/{id}")
    public Response<None> takeCourse(@PathVariable("id") String id) {
        // TODO
        return null;
    }

    @DeleteMapping("/course/{id}")
    public Response<None> dropCourse(@PathVariable("id") String id) {
        // TODO
        return null;
    }

    @GetMapping("/course")
    public Response<None> getSelectedCourse(@RequestBody List<Long> semestersId) {
        // TODO
        return null;
    }

}