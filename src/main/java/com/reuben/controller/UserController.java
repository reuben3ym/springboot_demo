package com.reuben.controller;

import com.reuben.dao.UserDao;
import com.reuben.pojo.User;
import com.reuben.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Api(tags = "User相关api")
@Validated
public class UserController {
    @Autowired
    private User user_default;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @PostMapping("/testPost")
    @ApiOperation(value = "post提交User", notes = "需要User作为参数", httpMethod = "POST")
    public String testPost(@ApiParam(value = "用户名、密码", required = true) User user) {
        return "Success! Hello!" + user.getUserName() + ",your password id" + user.getUserPassword();
    }

    @GetMapping("/getDefaultUser")
    @ApiOperation(value = "获取默认user", notes = "无需参数", httpMethod = "GET")
    public User getDefaultUser() {
        return user_default;
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加User", notes = "需要User作为参数", httpMethod = "POST")
    public String addUser(@ApiParam(value = "用户名、密码、邮箱", required = true) User user) {
        if (null != user && 0 != user.getUserName().length()) {
            user.setIsdel("0");//默认未删除
            userDao.save(user);
            return "save Success";
        } else
            return "false";
    }

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取所有User", notes = "无需参数", httpMethod = "GET")
    public String getAllUser() {
        return userDao.findAll().toString();
    }

    @PostMapping("/deleteUserById")
    @ApiOperation(value = "通过id删除User", notes = "需要id作为参数", httpMethod = "POST")
    public String deleUserById(Integer id) {
        return userService.deleteByUserId(id);
    }


}
