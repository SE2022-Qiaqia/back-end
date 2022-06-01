package com.whu.se2022.qiaqia.coursesystem.controller;


import com.alibaba.fastjson.JSONObject;
import com.whu.se2022.qiaqia.coursesystem.dto.request.login.LoginParam;
import com.whu.se2022.qiaqia.coursesystem.dto.response.ResponseRes;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import com.whu.se2022.qiaqia.coursesystem.util.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;




@Slf4j
@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;


    @PostMapping("/login")
    public ResponseRes<String> Login(@RequestBody LoginParam loginParam){
        ResponseRes<String> res = new ResponseRes<>();
        try {
            User user = userService.getUserInfoById(loginParam.getId());
            Long username = user.getUserId();
            String password = user.getPassword();
            if(password.equals(loginParam.getPassword()))
            {
                res.setData(JwtUtil.createToken(loginParam.getId()));
                res.setMsg("登录成功");
            }
            else
            {
                res.setData("");
                res.setMsg("密码错误");
            }
            return res;
        }
        catch (Exception e){
            res.setMsg("服务器错误"+e.getMessage());
            res.setData("");
            return res;
        }
    }

    @PostMapping("/register")
    public ResponseRes<Boolean> register(@RequestBody JSONObject jsonObject){
        return new ResponseRes<>(501,null,false);
    }
}
