package com.whu.se2022.qiaqia.coursesystem.controller;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import com.whu.se2022.qiaqia.coursesystem.util.ResponseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/user")
    public ResponseRes<User> getUserByName(@RequestParam String name){
        try {

            return  new ResponseRes<>(userService.getUserByName(name));
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),new User());
        }
    }

}
