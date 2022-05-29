package com.whu.se2022.qiaqia.coursesystem.mapper;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.apache.ibatis.annotations.*;
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

    @Insert("insert into course " +
            "(course_name,credit,course_hour,institute_id) " +
            "values " +
            "(#{courseName}, #{credit},#{courseHour},#{instituteId})")
    public boolean insertCourse(@Param("courseName") String courseName,@Param("credit") Integer credit,
                                @Param("courseHour") Integer courseHour,@Param("instituteId") Long instituteId);

    @Insert("insert into course_head " +
            "(teacher_id,head_time,head_address,course_id,head_year,volume,volume_left,head_term) " +
            "values " +
            "(#{teacherId},#{headTime},#{headAddress},#{courseId}, " +
            "#{headYear},#{volume},#{volume},#{headTerm})")
    public boolean insertCourseHead(@Param("teacherId") Long id,@Param("headTime") String headTime,
                                    @Param("headAddress") String headAddress,@Param("courseId") Long courseId,
                                    @Param("headYear") Integer headYear,@Param("volume") Integer volume,
                                    @Param("headTerm") Integer term);

    @Update("update course_head set " +
            "teacher_id = #{teacherId}, " +
            "head_time = #{headTime}, " +
            "head_address = #{headAddress}, " +
            "course_id = #{courseId}, " +
            "head_year = #{headYear}, " +
            "volume = #{volume}, " +
            "volume_left = #{volumeLeft}, " +
            "head_term = #{headTerm} " +
            "where " +
            "head_id = #{headId}")
    public boolean updateCourseHead(@Param("teacherId") Long id,@Param("headTime") String headTime,
                                    @Param("headAddress") String headAddress,@Param("courseId") Long courseId,
                                    @Param("headYear") Integer headYear,@Param("volume") Integer volume,
                                    @Param("volumeLeft") Integer volume_left,@Param("headTerm") Integer term,
                                    @Param("headId") Long headId);

    @Select("select * from " +
            "head_user_rel inner join course_head on head_user_rel.head_id = course_head.head_id " +
            "inner join course on course_head.course_id = course.course_id " +
            "inner join institute on course.institute_id = institute.institute_id " +
            "inner join user on course_head.teacher_id = user.user_id " +
            "where student_id = #{studentId} and `state` = 1")
    public List<CourseHead> getCourseOfStu(@Param("studentId") Long studentId);


    @Select("select user_id,roll_date,`name`,institute_name,user.institute_id from " +
            "head_user_rel inner join user on head_user_rel.student_id = user.user_id " +
            "inner join institute on institute.institute_id = user.institute_id " +
            "where head_id = #{headId} and `state` = 1")
    public List<User> getStudentOfCourse(@Param("headId") Long headId);


    @Select("select count(*) from " +
            "head_user_rel where " +
            "student_id = #{studentId} and head_id = #{headId}")
    public Integer getCountOfHeadUserRel(@Param("studentId") Long studentId,@Param("headId") Long headId);

    @Insert("insert into course_user_rel " +
            "(student_id,head_id,`state`)" +
            "values " +
            "(#{studentId},#{headId},1)")
    public void insertHeadUserRelForceCheck(@Param("studentId") Long studentId,@Param("headId") Long headId);

    @Update("update head_user_rel set " +
            "`state` = 1 where " +
            "student_id = #{studentId} and head_id = #{headId}")
    public void updateHeadUserRelForceCheck(@Param("studentId") Long studentId,@Param("headId") Long headId);

    @Update("update head_user_rel set " +
            "`state` = 0 where " +
            "student_id = #{studentId} and head_id = #{headId}")
    public void updateHeadUserRelForceUncheck(@Param("studentId") Long studentId,@Param("headId") Long headId);


}
