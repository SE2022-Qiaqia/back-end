package com.whu.se2022.qiaqia.coursesystem.mapper;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper
public interface CourseMapper {

    @Select("select * from course where course_id = #{id}")
    public Course getCourseById(@Param("id") Long id);

    @Select("select * from " +
            "course_head inner join course on course_head.course_id = course.course_id " +
            "inner join institute on course.institute_id = institute.institute_id " +
            "inner join user on course_head.teacher_id = user.user_id " +
            "where head_year= #{year} and head_term= #{term}")
    public List<CourseHead> getValidCourse(@Param("year") Long year, @Param("term") Integer term);


    @Update("update course set " +
            "course_name = #{courseName}, " +
            "credit = #{credit}, " +
            "course_hour = #{courseHour}, " +
            "institute_id = #{instituteId} " +
            "where course_id = #{courseId}")
    public boolean updateCourse(@Param("courseName") String courseName,@Param("credit") Integer credit,
                                @Param("courseHour") Integer courseHour,@Param("instituteId") Long instituteId,
                                @Param("courseId") Long courseId);
}
