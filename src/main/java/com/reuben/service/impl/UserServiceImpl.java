package com.reuben.service.impl;

import com.reuben.dao.UserDao;
import com.reuben.pojo.User;
import com.reuben.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @program: springboot_demo
 **/
@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    /**
     * @Description:
     * @Param: [id]
     * @return: java.lang.String
     */
    @Override
    public String deleteByUserId(Integer id) {

        Optional<User> byId = userDao.findById(id);//通过id查询是否存在
        if (null == byId) {
            return "User not exist!";
        } else
            userDao.deleteByUserId(id);
        return "delete Success!";
    }
}
