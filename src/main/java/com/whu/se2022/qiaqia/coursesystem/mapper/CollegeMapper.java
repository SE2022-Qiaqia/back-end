package com.whu.se2022.qiaqia.coursesystem.mapper;


import com.whu.se2022.qiaqia.coursesystem.entity.College;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Mapper
public interface CollegeMapper {
    @Select("select * from college where college_id = #{id}")
    public College getCollegeById(@Param("id") Long id);
    @Select("select * from college where college_id like CONCAT('%',#{name},'%')")
    public List<College> getCollegeByName(@Param("name") String name);
    @Insert("insert into college ('college_name','created_at','updated_at') value (#{name},'2022-05-30T23:00:00Z','2022-05-30T23:00:00Z')")
    public boolean addCollege(@Param("name") String name);
}
