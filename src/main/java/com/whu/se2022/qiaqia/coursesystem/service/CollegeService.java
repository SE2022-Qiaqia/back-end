package com.whu.se2022.qiaqia.coursesystem.service;

import com.whu.se2022.qiaqia.coursesystem.entity.College;
import com.whu.se2022.qiaqia.coursesystem.mapper.CollegeMapper;
import io.swagger.v3.oas.annotations.servers.Server;
import org.apache.ibatis.annotations.Options;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeMapper collegeMapper;

    public College getCollegeById(Long collegeId) {
        return collegeMapper.getCollegeById(collegeId);
    }

    public List<College> getCollegeByName(String collegeName){
        return collegeMapper.getCollegeByName(collegeName);
    }

    public boolean addCollege(String name)
    {
        return collegeMapper.addCollege(name);
    }
}
