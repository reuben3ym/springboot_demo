package com.reuben.controller;

import com.reuben.entity.User;
import com.reuben.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
@Api(tags = "User相关api")
@Validated
public class UserController {
    @Autowired
    private User user_default;

    @Autowired
    private UserService userService;

    @PostMapping("/testPost")
    @ApiOperation(value = "post提交User", notes = "需要User作为参数", httpMethod = "POST")
    public String testPost(@ApiParam(value = "userName:用户名、userPassword:密码", required = true)
                           @RequestBody User user) {
        System.out.println(user);
        return "Success! Hello!" + user.getUserName() + ",your password is:" + user.getUserPassword();
    }

    @GetMapping("/getDefaultUser")
    @ApiOperation(value = "获取默认user", notes = "无需参数", httpMethod = "GET")
    public User getDefaultUser() {
        return user_default;
    }

    @PostMapping("/addUser")
    @ApiOperation(value = "添加User", notes = "需要User作为参数", httpMethod = "POST")
    public String addUser(@ApiParam(value = "userName:用户名、userPassword:密码、email:邮箱", required = true)
                          @RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/getAllUser")
    @ApiOperation(value = "获取所有User", notes = "无需参数", httpMethod = "GET")
    public String getAllUser() {
        return userService.findAll();
    }

    @PostMapping("/findByUserName")
    @ApiOperation(value = "通过userName获取User", notes = "需要userName作为参数", httpMethod = "POST")
    public String findByUserName(@ApiParam(value = "用户名", required = true)
                                 @RequestBody String name) {
        return userService.findByUserName(name);
    }

    @PostMapping("/deleteUserById")
    @ApiOperation(value = "通过id删除User", notes = "需要id作为参数", httpMethod = "POST")
    public String deleUserById(@ApiParam(value = "用户id", required = true)
                               @RequestBody Integer id) {
        return userService.deleteByUserId(id);
    }

    @PostMapping("/update")
    @ApiOperation(value = "修改User", notes = "需要User作为参数", httpMethod = "POST")
    public String update(@ApiParam(value = "userId:id、userName:用户名、userPassword:密码、email:邮箱", required = true)
                         @RequestBody User user) {
        return userService.update(user);
    }


}
