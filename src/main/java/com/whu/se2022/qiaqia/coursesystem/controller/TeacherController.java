package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.response.None;
import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseSpecific;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @GetMapping("/course/{semesterId}")
    public Response<List<CourseSpecific>> getCoursesForTeacher(@PathVariable("semesterId") Long semesterId) {
        // TODO
        return null;
    }

    @PostMapping("/course/{courseId}/{studentId}")
    public Response<None> updateScores(@PathVariable("courseId") String courseId,
                                       @PathVariable("studentId") String studentId,
                                       @RequestParam("scores") float scores) {
        // TODO
        return null;
    }

}
