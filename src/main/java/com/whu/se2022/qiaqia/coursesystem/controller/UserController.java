package com.whu.se2022.qiaqia.coursesystem.controller;

import com.whu.se2022.qiaqia.coursesystem.dto.request.ChangePasswordParams;
import com.whu.se2022.qiaqia.coursesystem.dto.request.LoginParams;
import com.whu.se2022.qiaqia.coursesystem.dto.response.None;
import com.whu.se2022.qiaqia.coursesystem.dto.response.Response;
import com.whu.se2022.qiaqia.coursesystem.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    @PreAuthorize("isAuthenticated()")
    public Response<User> getCurrentUserInfo() {
        // TODO
        return null;
    }

    @GetMapping("/info/{id}")
    @PreAuthorize("hasAnyRole('teacher', 'admin')")
    public Response<User> getOtherUserInfo(@PathVariable("id") long id) {
        // TODO
        return null;
    }

    @PostMapping("/login")
    public Response<String> login(@RequestBody LoginParams loginParams) {
        // TODO
        return null;
    }

    @PostMapping("/new_password")
    @PreAuthorize("isAuthenticated()")
    public Response<None> changePassword(@RequestBody ChangePasswordParams changePasswordParams) {
        // TODO
        return null;
    }

    @PostMapping("/new_password/{id}")
    @PreAuthorize("hasRole('admin')")
    public Response<None> changePasswordForOtherUser(@RequestBody ChangePasswordParams changePasswordParams,
                                         @PathVariable("id") long userId) {
        // TODO
        return null;
    }

}
