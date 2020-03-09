package com.reuben.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@ApiModel(value = "user对象", description = "用户对象user")
@Component
@ConfigurationProperties(prefix = "user")
@Validated
public class User implements Serializable {
    @ApiModelProperty(value = "用户名", name = "userName", example = "reuben")
    @NotBlank //@NotNull  @NotEmpty
    private String userName;

    @NotBlank
    @ApiModelProperty(value = "密码", name = "userPassword", example = "reuben")
    private String userPassword;

    @ApiModelProperty(value = "邮箱", name = "email", example = "reuben@mail.com")
    @NotBlank
    @Email
    private String email;

    public User() {

    }

    public User(@NotNull String userName, @NotNull String userPassword, @Email String email) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", email='" + email + '\'' +
                '}';
    }


}
