package com.whu.se2022.qiaqia.coursesystem.controller;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseSpecific;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    public boolean addUser(String userName, String password) {

        return false;
    }

    public boolean addCourse(CourseSpecific course) {

        return false;
    }

    public boolean addStudenttoCourse(User stu, CourseSpecific course) {

        return false;
    }

    public boolean deleteUser(Long id) {

        return false;
    }

    public boolean deleteCourse(Long id) {

        return false;
    }

    public boolean deleteStudentFromCourse(Long stuId, Long courseId) {

        return false;
    }

    public boolean alterCourseInfo(Course course) {

        return false;
    }

    public boolean alterUserInfo(User user)
    {

        return false;
    }

    public Course getCourseInfo(Long id)
    {

        return null;
    }

    public User getUserInfo(Long id)
    {

        return null;
    }
    public Integer getGradeInfo(Long stuId,Long courseId)
    {

        return null;
    }
    public List<Integer> getAllgradeInfo(Long stuId)
    {

        return null;
    }
    public String getTermInfo()
    {

        return null;
    }
    public String getDepartmentInfo(Long deptId)
    {
        return null;
    }
}