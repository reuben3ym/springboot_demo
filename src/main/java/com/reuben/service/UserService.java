package com.reuben.service;

import com.reuben.entity.User;
import org.springframework.stereotype.Service;


/**
 * @program: springboot_demo
 **/
@Service
public interface UserService {


    /**
     * @Description: 添加User
     * @Param: [user]
     * @return: String
     */
    String save(User user);

    /**
     * @Description: 查询所有
     * @return: String
     */
    String findAll();

    /**
     * @Description: 通过id查找
     * @Param: [name]
     * @return: String
     */
    String findByUserName(String name);

    /**
     * @Description: 逻辑删除
     * @Param: [id]
     * @return: String
     */
    String deleteByUserId(Integer id);

    /**
     * @Description: update
     * @Param: [user]
     * @return: String
     */
    String update(User user);
}
