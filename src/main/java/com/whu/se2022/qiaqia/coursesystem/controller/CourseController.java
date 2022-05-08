package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.request.QueryCourse;
import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseSpecific;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping("/list")
    public Response<List<CourseSpecific>> queryCourses(@RequestBody QueryCourse queryCourse,
                                                       @RequestParam("page") int page,
                                                       @RequestParam("size") int size) {
        // TODO
        return null;
    }

}
