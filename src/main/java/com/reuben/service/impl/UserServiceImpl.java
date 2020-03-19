package com.reuben.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.dao.UserDao;
import com.reuben.pojo.User;
import com.reuben.pojo.msgAndData;
import com.reuben.service.UserService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @program: springboot_demo
 **/
@Component
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private msgAndData msgAndData;
    //初始化Jackson的ObjectMapper
    private ObjectMapper mapper = new ObjectMapper();

    @Override

    /**
     * @Description: 添加User
     * @Param: [user]
     * @return: java.lang.String
     */
    public String save(User user) {
        if (null != user && 0 != user.getUserName().length()) {
            user.setIsdel("0");//默认未删除
            userDao.save(user);
            return "save Success";
        } else
            return "false";

    }

    /**
     * @Description: 获取所有User
     * @Param: []
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String findAll() {
        List<User> all = userDao.findAll();
        String result = mapper.writeValueAsString(all);
        return result;

    }

    /**
     * @Description: 通过userName查询
     * @Param: [name]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String findByUserName(String name) {
        String name_str = mapper.readValue(name, String.class);
        List<User> byUserName = userDao.findByUserName(name_str);
        String result = mapper.writeValueAsString(byUserName);
        return result;
    }

    /**
     * @Description:
     * @Param: [id]
     * @return: java.lang.String
     */
    @SneakyThrows
    @Override
    public String deleteByUserId(Integer id) {

        Optional<User> byId = userDao.findById(id);//通过id查询是否存在
        //log.info(String.valueOf(byId.isPresent()));

        //将返回结果封装到msgAndData
        if (!byId.isPresent()) {
            msgAndData.setMessage("User not exist!");
        } else {
            userDao.deleteByUserId(id);
            msgAndData.setMessage("delete Success!");
            byId.get().setIsdel("1");
            msgAndData.setData(byId.get().toString());

        }
        //json格式化
        String result = mapper.writeValueAsString(msgAndData);
        return result;

    }

    @SneakyThrows
    @Override

    /**
     * @Description: update
     * @Param: [user]
     * @return: java.lang.String
     */
    public String update(User user) {
        //System.out.println(user);
        userDao.update(user.getUserId(),
                user.getUserName(),
                user.getUserPassword(),
                user.getEmail());

        msgAndData.setMessage("update Success!");
        msgAndData.setData(userDao.findById(user.getUserId()).get().toString());
        String result = mapper.writeValueAsString(msgAndData);
        return result;
    }
}
