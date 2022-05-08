package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.Semester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/semester")
public class SemesterController {

    @GetMapping("/")
    public Response<List<Semester>> getSemester() {
        // TODO
        return null;
    }

}
