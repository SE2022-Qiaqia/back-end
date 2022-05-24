package com.whu.se2022.qiaqia.coursesystem.controller;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable Long id){
        return userService.getUserById(id);
    }

}
