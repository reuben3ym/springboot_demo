package com.reuben.springboot_demo.dao;

import com.reuben.dao.UserDao;
import com.reuben.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserDaoTests {
    @Autowired
    private UserDao userDao;

    /**
     * @Description: 测试通过id查询用户
     */
    @Test
    public void testFindById() {
        Optional<User> byUserId = userDao.findById(1);
        log.info(byUserId.toString());
    }

    /**
     * @Description: 测试通过userName查询用户
     */
    @Test
    public void testFindByuserName() {
        String ts_userName = "da";
        List<User> da = userDao.findByUserName(ts_userName);
        log.info(da.toString());

    }

    /**
     * @Description: 测试添加用户
     */
    @Test
    public void testSave() {
        User te_user = new User("ceshi",
                "233",
                "qq@qq.com");
        userDao.save(te_user);
    }

    /**
     * @Description: 测试逻辑删除
     */
    @Test
    public void testDeleteByuserId() {
        int ts_userId = 3;
        userDao.deleteByUserId(ts_userId);
    }
}
