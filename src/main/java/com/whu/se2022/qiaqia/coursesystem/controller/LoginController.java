package com.whu.se2022.qiaqia.coursesystem.controller;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import com.whu.se2022.qiaqia.coursesystem.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;




@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public Map<String,Object> Login(@RequestBody Map<String,Object> mapU){

        try {
            Map<String,Object> map = new HashMap<>();
            String username = (String)mapU.get("username");
            String password = (String)mapU.get("password");
            User userByName = userService.getUserByName(username);
            if(password.equals(userByName.getPassword()))
            {
                map.put("username",userByName.getName());
                map.put("id",userByName.getUserId());
                map.put("role",userByName.getRole());
                map.put("token",JwtUtil.createToken(userByName.getUserId()));
            }
            else
                map.put("msg","密码错误");
            return map;
        }
        catch (Exception e){
            LoginController.log.info(e.getMessage());
            HashMap<String, Object> Map = new HashMap<>();
            Map.put("msg",e.getMessage());
            return Map;
        }
    }
}
