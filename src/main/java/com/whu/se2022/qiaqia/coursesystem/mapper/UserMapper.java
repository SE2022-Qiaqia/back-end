package com.whu.se2022.qiaqia.coursesystem.mapper;


import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select * from user where user_id = #{id}")
    public User getUserById(@Param("id") Long id);

    @Select("select * from user where `name` = #{username}")
    public User getUserByName(@Param("username") String username);
}
