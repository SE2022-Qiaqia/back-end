package com.whu.se2022.qiaqia.coursesystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import com.whu.se2022.qiaqia.coursesystem.util.JwtUtil;
import com.whu.se2022.qiaqia.coursesystem.util.ResponseRes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;




@Slf4j
@RestController
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/login")
    public Map<String,Object> Login(@RequestBody Map<String,Object> mapU){

        try {
            Map<String,Object> map = new HashMap<>();
            String username = (String)mapU.get("username");
            String password = (String)mapU.get("password");
            User userByName = userService.getUserByName(username);
            if(bCryptPasswordEncoder.matches(password,userByName.getPassword()))
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

    @PostMapping("/register")
    public ResponseRes<Boolean> register(@RequestBody JSONObject jsonObject){
        try{
            userService.inserUser(jsonObject.getString("username"),
                    bCryptPasswordEncoder.encode(jsonObject.getString("password")),
                    jsonObject.getInteger("role"),
                    jsonObject.getInteger("instituteId"));
            return new ResponseRes<>(true);
        }catch (Exception e){
            return new ResponseRes<>(501,e.getMessage(),false);
        }
    }
}
