package com.whu.se2022.qiaqia.coursesystem.service;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;


    public User getUserById(Long id){
        return userMapper.getUserById(id);
    }

    public User getUserByName(String name){return userMapper.getUserByName(name);}
}
