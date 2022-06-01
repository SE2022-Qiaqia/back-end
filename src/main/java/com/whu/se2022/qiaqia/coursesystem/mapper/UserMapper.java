package com.whu.se2022.qiaqia.coursesystem.mapper;

import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user WHERE user_id = #{id}")
    public User getUserById(@Param("id") Long id);


//    @Select("<script>" +
//            "SELECT * " +
//            "FROM user INNER JOIN college ON user.course_id = college.course_id " +
//            "LIMIT page,size" +
//            "WHERE " +
//            "college_id IN " +
//            "<foreach item='item_college' index='index' collection='colleges_list' open='(' separator=',' close=')'>" +
//            "#{item_college}" +
//            "</foreach> " +
//            "AND " +
//            "role IN" +
//            "<foreach item='role' index='index' collection='colleges_list' open='(' separator=',' close=')'>" +
//            "#{item_role}" +
//            "</foreach> " +
//            "AND " +
//            "user.entrance_year >= entrance_year_from " +
//            "AND " +
//            "user.entrance_year <= entrance_year_to " +
//            "AND " +
//            "user.username LIKE username_param " +
//            "AND " +
//            "user.realname LIKE realname_param " +
//            "AND " +
//            "user.id LIKE id_param " +
//            "</script>")
    @Select("<script>" +
                "SELECT * FROM user INNER JOIN college ON user.college_id=college.college_id " +
                "WHERE " +
                    "user.entrance_year &gt;= #{entrance_year_from} " +
                "AND " +
                    "user.entrance_year &lt;= #{entrance_year_to} " +
                "AND " +
                    "user.id LIKE #{id_param} " +
                "AND " +
                "user.college_id IN "+
                "<foreach item='college_id_item' index='index' collection='colleges_list' open='(' separator=',' close=')'>" +
                "#{college_id_item}" +
                "</foreach> " +
                "AND " +
                "user.role IN " +
                "<foreach item='role_item' index='index' collection='rolesList' open='(' separator=',' close=')'>" +
                "#{role_item}" +
                "</foreach> " +
            "</script>"
    )

    List<User> getUserList(
            @Param("colleges_list") List<String> collegesList,
            @Param("roles_list") List<Integer> rolesList,
            @Param("entrance_year_from") int entranceYearFrom,
            @Param("entrance_year_to") int entranceYeaTo,
            @Param("id_param") int id,
            @Param("page") int page,
            @Param("realname_param") String realname,
            @Param("username_param") String username,
            @Param("size") int size
            );




    @Insert("INSERT INTO user " +
            "(`user_id`,`username`,`realname`,`password`,`role`,`entrance_year`,`college_id`,`created_at`,`updated_at`) " +
            "values " +
            "(#{user_id},#{username},#{realname},#{password},#{role},#{entrance_year},#{college_id},#{create_at},#{update_at})"
    )
    public boolean addUser(
            @Param("user_id") Long user_id,
            @Param("username") String username,
            @Param("realname") String realname,
            @Param("password") String password,
            @Param("role") Integer role,
            @Param("entrance_year") int entrance_year,
            @Param("college_id") Long college_id,
            @Param("create_at") String create_at,
            @Param("update_at") String update_at
    );


    @Update("UPDATE user SET " +
            "username=#{username}," +
            "realname=#{realname}," +
            "role=#{role}," +
            "entrance_year=#{entrance_year}," +
            "college_id=#{college_id}," +
            "created_at=#{create_at}," +
            "updated_at=#{update_at} " +
            "WHERE " +
            "user_id=#{user_id}")
    public boolean updateUser(
            @Param("user_id") Long user_id,
            @Param("username") String username,
            @Param("realname") String realname,
            @Param("role") int role,
            @Param("entrance_year") int entrance_year,
            @Param("college_id") Long college_id,
            @Param("create_at") String create_at,
            @Param("update_at") String update_at
    );



    @Delete("DELETE FROM user WHERE user_id=#{user_id}")
    public boolean deleteUser(
            @Param("user_id") Long user_id
    );

    @Update("UPDATE user SET password=#{password} WHERE user_id=#{user_id}")
    public boolean alterPassword(
            @Param("user_id") Long user_id,
            @Param("password") String password
    );


}
