package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.response.ResponseRes;
import com.whu.se2022.qiaqia.coursesystem.entity.College;
import com.whu.se2022.qiaqia.coursesystem.service.CollegeService;
import io.swagger.annotations.Api;
import org.intellij.lang.annotations.RegExp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "CollegeController")
@RestController
@RequestMapping("college")
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @PostMapping("list")
    public ResponseRes<List<College>> getCollege(@RequestBody String name)
    {
        ResponseRes<List<College>> res = new ResponseRes<>();
        try{
            List<College> colleges = collegeService.getCollegeByName(name);
            res.setData(colleges);
            res.setMsg("成功！");
        }catch (Exception e) {
            res.setData(null);
            res.setMsg("查无此校！"+e.getMessage());
        }
        return res;
    }

    @PostMapping("new")
    public ResponseRes<Boolean> addCollege(@RequestBody String name)
    {
        ResponseRes<Boolean> res = new ResponseRes<>();
        try{
            collegeService.addCollege(name);
            res.setMsg("添加成功！");
            res.setData(true);
        }catch (Exception e) {
            res.setMsg("笑死了，怎么老是添加些重复的"+e.getMessage());
            res.setData(false);
        }
        return res;
    }
}
