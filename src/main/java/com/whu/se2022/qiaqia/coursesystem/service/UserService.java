package com.whu.se2022.qiaqia.coursesystem.service;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

    public User getUserByName(String name) throws Exception{
        try {
            return userMapper.getUserByName(name);
        }
        catch (Exception e){
            throw  e;
        }
    }
    public Boolean inserUser(String username,String psw,Integer role,Integer instituteId) throws  Exception{
        try {
            Date dNow = new Date();
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
            userMapper.insertUser(username,role,ft.format(dNow),psw,instituteId);
            return true;
        }catch (Exception e){
            throw e;
        }
    }
}
