package com.whu.se2022.qiaqia.coursesystem.service;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.mapper.CollegeMapper;
import com.whu.se2022.qiaqia.coursesystem.mapper.CourseMapper;
import com.whu.se2022.qiaqia.coursesystem.mapper.CollegeMapper;
import com.whu.se2022.qiaqia.coursesystem.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
@Slf4j
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    CollegeMapper collegeMapper;



    public Course getCourseById(Long id){return courseMapper.getCourseById(id);}

    public List<CourseHead> getValidCourse(){
        Calendar calendar = Calendar.getInstance();
        Long year = (long) calendar.get(Calendar.YEAR);
        Integer  term = calendar.get(Calendar.MONTH)<7?1:2;
        List<CourseHead> headList = courseMapper.getValidCourse(year,term);
        for (CourseHead head:headList) {
            String str = head.getHeadTime();
            String weekDay = str.substring(1,2);
            String classNum = str.substring(3,6);
            head.setHeadTime("星期"+weekDay+"  "+classNum+"节");
        }
        return headList;
    }

    public boolean updateCourse(String courseName, Integer credit,
                                Integer courseHour, Long instituteId,
                                Long courseId) throws Exception{
        try {
            collegeMapper.getCollegeById(instituteId);
        }catch (Exception e){
            throw new Exception("机构ID不存在");
        }
        return courseMapper.updateCourse(courseName,credit,courseHour,instituteId,courseId);
    }

    public boolean insertCourse(String courseName, Integer credit,
                                Integer courseHour, Long instituteId)throws Exception{
        try {
            collegeMapper.getCollegeById(instituteId);
        }catch (Exception e){
            throw new Exception("机构ID不存在");
        }
        return courseMapper.insertCourse(courseName,credit,courseHour,instituteId);
    }

    public boolean insertCourseHead(Long id,String headTime, String headAddress,
                                    Long courseId, Integer headYear,Integer volume,
                                    Integer term) throws Exception{
        try{
            return courseMapper.insertCourseHead(id,headTime,headAddress, courseId, headYear,volume, term);
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    public boolean updateCourseHead(Long id,String headTime, String headAddress,
                                    Long courseId, Integer headYear,Integer volume,
                                    Integer volumeLeft, Integer term,
                                    Long headId) throws Exception{
        try {
            return courseMapper.updateCourseHead(id,headTime,headAddress, courseId, headYear,volume,
                    volumeLeft, term,headId);
        }catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }
    }

    public List<CourseHead> getCourseOfStu(Long studentId)throws Exception{
        try{
            List<CourseHead> headList = courseMapper.getCourseOfStu(studentId);
            for (CourseHead head:headList) {
                String str = head.getHeadTime();
                String weekDay = str.substring(1,2);
                String classNum = str.substring(3,6);
                head.setHeadTime("星期"+weekDay+"  "+classNum+"节");
            }
            return headList;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<User> getStudentOfCourse(Long courseId) throws Exception{
        try {
            return courseMapper.getStudentOfCourse(courseId);
        }catch (Exception e){
            throw e;
        }
    }

    public void forceCheck(Long studentId, Long headId) throws Exception{
        try {
            if(courseMapper.getCountOfHeadUserRel(studentId,headId) == 0){
                courseMapper.insertHeadUserRelForceCheck(studentId,headId);
            }else {
                courseMapper.updateHeadUserRelForceCheck(studentId,headId);
            }
        }catch (Exception e){
            throw e;
        }
    }


    public void forceUncheck(Long studentId, Long headId) throws Exception{
        try {
            if(courseMapper.getCountOfHeadUserRel(studentId,headId) == 0){
                throw new Exception("该学生未选该课头");
            }else {
                courseMapper.updateHeadUserRelForceUncheck(studentId,headId);
            }
        }
        catch (Exception e){
            throw e;
        }
    }

    public void register(String username,String psw)throws Exception{
        try {

        }catch (Exception e){
            throw e;
        }
    }
}
