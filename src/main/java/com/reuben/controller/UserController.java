package com.reuben.controller;

import com.reuben.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Api(tags = "User相关api")
public class UserController {
    @Autowired
    private User user_default;

    @PostMapping("/testPost")
    @ApiOperation(value = "post提交User",notes = "需要User作为参数",httpMethod = "POST")
    public String testPost(@ApiParam(value = "用户名、密码",required = true) User user){
        return "Success! Hello!"+user.getUserName()+",your password id"+user.getUserPassword();
    }
    @GetMapping("/getDefaultUser")
    @ApiOperation(value = "获取默认user",notes = "无需参数",httpMethod = "GET")
    public User getDefaultUser(){
        return user_default;
    }
}
