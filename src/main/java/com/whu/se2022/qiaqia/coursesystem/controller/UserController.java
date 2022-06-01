package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.request.GetUserListParam;
import com.whu.se2022.qiaqia.coursesystem.dto.request.UpdateUserInfoParam;
import com.whu.se2022.qiaqia.coursesystem.dto.response.GetUserInfoData;
import com.whu.se2022.qiaqia.coursesystem.dto.response.None;
import com.whu.se2022.qiaqia.coursesystem.dto.response.ResponseRes;
import com.whu.se2022.qiaqia.coursesystem.entity.College;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import com.whu.se2022.qiaqia.coursesystem.service.CollegeService;
import com.whu.se2022.qiaqia.coursesystem.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Api(tags = "UserController")
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @Autowired
    CollegeService collegeService;

    @ApiOperation(value = "获取当前用户信息")
    @GetMapping("/user")
    public ResponseRes<GetUserInfoData> getMyInfo(HttpServletRequest request)
    {
        Long user_id = (Long) request.getServletContext().getAttribute("user_id");
        ResponseRes<GetUserInfoData> res = new ResponseRes<GetUserInfoData>();
        try{
            User user = userService.getUserInfoById(user_id);
            College college = collegeService.getCollegeById(user.getCollegeId());
            GetUserInfoData getUserInfoData = new GetUserInfoData(
                    college,
                    user.getCreatedAt(),
                    user.getUpdatedAt(),
                    user.getEntranceYear(),
                    user.getUserId(),
                    user.getRealname(),
                    user.getRole(),
                    user.getUsername()
            );
            res.setData(getUserInfoData);
            res.setMsg("成功！");
        }catch (Exception e){
            res.setData(null);
            res.setMsg("失败！");
        }
        return res;
    }

    @ApiOperation("更新用户信息")
    @PostMapping("/user")
    public ResponseRes<GetUserInfoData> updateMyInfo(HttpServletRequest request,@RequestBody UpdateUserInfoParam myInfo) throws Exception {
        ResponseRes<GetUserInfoData> res = new ResponseRes<>();
        try {
            Long user_id = (Long) request.getServletContext().getAttribute("user_id");
            userService.updateUser(
                    new User(
                            user_id,
                            myInfo.getUsername(),
                            myInfo.getRealName(),
                            "",
                            myInfo.getRole(),
                            myInfo.getCollegeId(),
                            myInfo.getEntranceYear(),
                            "2022-05-30T23:00:00Z",
                            "2022-05-30T23:00:00Z"
                    )
            );
            User user = userService.getUserInfoById(user_id);
            College college = collegeService.getCollegeById(user.getCollegeId());
            GetUserInfoData getUserInfoData = new GetUserInfoData(
                    college,
                    user.getCreatedAt(),
                    user.getUpdatedAt(),
                    user.getEntranceYear(),
                    user.getUserId(),
                    user.getRealname(),
                    user.getRole(),
                    user.getUsername()
            );
            res.setData(getUserInfoData);
            res.setMsg("更新成功！");
        }catch (Exception e)
        {
            res.setMsg("更新信息非法！");
            res.setData(null);
        }
        return res;
    }

    @ApiOperation("获取用户列表")
    @PostMapping("/user/list")
    public ResponseRes<ArrayList<User>> getUserList(@RequestBody GetUserListParam getUserListParam)
    {
        ResponseRes<ArrayList<User>> res = new ResponseRes<>();
        ArrayList<User> userArrayList = new ArrayList<User>();

        return res;
    }

    @ApiOperation("添加用户")
    @PostMapping("/user/new")
    public ResponseRes<None> addUser(@RequestBody User user)
    {
        ResponseRes<None> res = new ResponseRes<None>();
        try{
            userService.addUser(user);
            res.setMsg("添加成功");
        }catch (Exception e){
            res.setMsg("添加失败,用户已存在!"+e.getMessage());
        }
        return res;
    }

    @ApiOperation("更新用户密码")
    @PostMapping("/user/pwd")
    public ResponseRes<Boolean> updateMyPassword(HttpServletRequest request,@RequestBody String password)
    {
        ResponseRes<Boolean> res = new ResponseRes<Boolean>();
        Long user_id = (Long) request.getServletContext().getAttribute("user_id");
        try{
            userService.updatePassword(user_id,password);
            res.setMsg("成功");
            res.setData(true);
        }catch (Exception e) {
            res.setMsg("失败");
            res.setData(false);
        }
        return res;
    }

    @ApiOperation("获取特定用户信息")
    @GetMapping("/user/{id}")
    public ResponseRes<GetUserInfoData> getUserInfo(@PathVariable("id") long id)
    {
        ResponseRes<GetUserInfoData> res = new ResponseRes<GetUserInfoData>();
        try{
            User user = userService.getUserInfoById(id);
            College college = collegeService.getCollegeById(user.getCollegeId());
            GetUserInfoData getUserInfoData = new GetUserInfoData(
                    college,
                    user.getCreatedAt(),
                    user.getUpdatedAt(),
                    user.getEntranceYear(),
                    user.getUserId(),
                    user.getRealname(),
                    user.getRole(),
                    user.getUsername()
            );
            res.setData(getUserInfoData);
            res.setMsg("成功！");
        }catch (Exception e){
            res.setData(null);
            res.setMsg("失败！");
        }
        return res;
    }

    @ApiOperation("更新特定用户信息")
    @PostMapping("/user/{id}")
    public ResponseRes<GetUserInfoData> updateUserInfo(@PathVariable("id") long id,@RequestBody UpdateUserInfoParam myInfo)
    {
        ResponseRes<GetUserInfoData> res = new ResponseRes<GetUserInfoData>();
        try{
            userService.updateUser(
                    new User(
                            id,
                            myInfo.getUsername(),
                            myInfo.getRealName(),
                            "",
                            myInfo.getRole(),
                            myInfo.getCollegeId(),
                            myInfo.getEntranceYear(),
                            "2022-05-30T23:00:00Z",
                            "2022-05-30T23:00:00Z"
                    )
            );
            User user = userService.getUserInfoById(id);
            College college = collegeService.getCollegeById(user.getCollegeId());
            GetUserInfoData getUserInfoData = new GetUserInfoData(
                    college,
                    user.getCreatedAt(),
                    user.getUpdatedAt(),
                    user.getEntranceYear(),
                    user.getUserId(),
                    user.getRealname(),
                    user.getRole(),
                    user.getUsername()
            );
            res.setData(getUserInfoData);
            res.setMsg("更新成功！");
        }catch (Exception e){

        }
        return res;
    }

    @ApiOperation("删除特定用户")
    @DeleteMapping("/user/{id}")
    public ResponseRes<Boolean> deleteUser(@PathVariable("id") long id)
    {
        ResponseRes<Boolean> res = new ResponseRes<Boolean>();
        try{
            userService.deleteUserById(id);
            res.setMsg("成功！");
            res.setData(true);
        }catch (Exception e){
            res.setMsg("删除失败，请检查删除对象是否存在！");
            res.setData(false);
        }
        return res;
    }

    @ApiOperation("更改特定用户密码")
    @PostMapping("/user/{id}/pwd")
    public ResponseRes<Boolean> updateUserPassword(@PathVariable("id") long id,@RequestBody String password)
    {
        ResponseRes<Boolean> res = new ResponseRes<Boolean>();
        try{
            userService.updatePassword(id,password);
            res.setMsg("成功");
            res.setData(true);
        }catch (Exception e) {
            res.setMsg("失败");
            res.setData(false);
        }
        return res;
    }
}
