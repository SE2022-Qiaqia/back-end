package com.whu.se2022.qiaqia.coursesystem.controller;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import com.whu.se2022.qiaqia.coursesystem.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public Map<String,Object> Login(@RequestBody String username,@RequestBody String password){

        try {
            User userByName = userService.getUserByName(username);
            if(password.equals(userByName.getPassword()))
            {
                Map<String,Object> map = new HashMap<>();
                map.put("username",userByName.getName());
                map.put("id",userByName.getUserId());
                map.put("role",userByName.getRole());
                map.put("token",JwtUtil.createToken(userByName.getUserId()));
                return map;
            }
            throw new RuntimeException("密码验证失败");
        }
        catch (Exception e){
            log.info(e.getMessage());
            HashMap<String, Object> Map = new HashMap<>();
            Map.put("msg",e.getMessage());
            return Map;
        }
    }
}
