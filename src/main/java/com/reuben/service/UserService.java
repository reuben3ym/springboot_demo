package com.reuben.service;

import com.reuben.dao.UserDao;
import com.reuben.pojo.User;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @program: springboot_demo
 **/
@Service
public interface UserService {

    /**
     * @Description: 逻辑删除
     * @Param: [id]
     * @return: String
     */
    String deleteByUserId(Integer id);
}
