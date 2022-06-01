package com.whu.se2022.qiaqia.coursesystem.service;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User getUserInfoById(Long user_id) {
        return userMapper.getUserById(user_id);
    }

    public boolean deleteUserById(Long user_id) throws Exception {
        try {
            return userMapper.deleteUser(user_id);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean addUser(User user) throws Exception {
        try {
            return userMapper.addUser(
                    user.getUserId(),
                    user.getUsername(),
                    user.getRealname(),
                    user.getPassword(),
                    user.getRole(),
                    user.getEntranceYear(),
                    user.getCollegeId(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean updateUser(User user) throws Exception {
        try {
            return userMapper.updateUser(
                    user.getUserId(),
                    user.getUsername(),
                    user.getRealname(),
                    user.getRole(),
                    user.getEntranceYear(),
                    user.getCollegeId(),
                    user.getCreatedAt(),
                    user.getUpdatedAt()
            );
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public boolean updatePassword(Long userId, String password) throws Exception {
        try{
            return userMapper.alterPassword(userId,password);
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public User getUserByName(String username) {
        return null;
    }

}
