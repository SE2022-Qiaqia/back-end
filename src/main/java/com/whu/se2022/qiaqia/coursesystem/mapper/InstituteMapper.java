package com.whu.se2022.qiaqia.coursesystem.mapper;


import com.whu.se2022.qiaqia.coursesystem.entity.Institute;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface InstituteMapper {


    @Select("select * from institute where institute_id = #{id}")
    public Institute getInstituteById(@Param("id") Long id);
}
