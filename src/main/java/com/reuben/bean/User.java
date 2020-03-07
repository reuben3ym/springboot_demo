package com.reuben.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
@ApiModel(value="user对象",description="用户对象user")
@Component
@ConfigurationProperties(prefix = "user")
public class User implements Serializable {
    @ApiModelProperty(value="用户名",name="userName",example="xingguo")
    private String userName;
    @ApiModelProperty(value="密码",name="userPassword",example="xingguo")
    private String userPassword;

    public User() {

    }

    public User(String userName, String userPassword) {
        this.userName = userName;
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


}
