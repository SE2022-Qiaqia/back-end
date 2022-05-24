package com.whu.se2022.qiaqia.coursesystem.mapper;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper
public interface CourseMapper {

    @Select("select * from course where course_id = #{id}")
    public Course getCourseById(@Param("id") Long id);
}
