package com.whu.se2022.qiaqia.coursesystem.service;

import com.whu.se2022.qiaqia.coursesystem.entity.Course;
import com.whu.se2022.qiaqia.coursesystem.entity.CourseHead;
import com.whu.se2022.qiaqia.coursesystem.mapper.CourseMapper;
import com.whu.se2022.qiaqia.coursesystem.mapper.InstituteMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CourseService {
    @Autowired
    CourseMapper courseMapper;

    @Autowired
    InstituteMapper instituteMapper;


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
            instituteMapper.getInstituteById(instituteId);
        }catch (Exception e){
            throw new Exception("机构ID不存在");
        }
        return courseMapper.updateCourse(courseName,credit,courseHour,instituteId,courseId);
    }
}
