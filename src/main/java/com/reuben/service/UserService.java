package com.reuben.service;

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
