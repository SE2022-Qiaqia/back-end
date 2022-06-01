package com.whu.se2022.qiaqia.coursesystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;

@RestController
@RequestMapping("hello")
public class HelloController {

    @GetMapping("greeting")
    public String hello() {
        return "Hello! SalHe!" + Calendar.getInstance().getTime();
    }

}
