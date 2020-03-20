package com.reuben.springboot_demo.dao;

import com.reuben.dao.UserDao;
import com.reuben.entity.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Transactional
public class UserDaoTests extends SpringbootDemoApplicationTests {
    @Autowired
    private UserDao userDao;

    /**
     * @Description: 测试通过id查询用户
     */
    @Test
    public void testFindById() {
        Optional<User> byUserId = userDao.findById(1);
        System.out.println(byUserId.isPresent());
        Assert.assertTrue(true == byUserId.isPresent());
        //log.info(byUserId.toString());
    }

    /**
     * @Description: 测试通过userName查询用户
     */
    @Test
    public void testFindByuserName() {
        String ts_userName = "da";
        List<User> da = userDao.findByUserName(ts_userName);
        Assert.assertTrue(da.size() > 0);
        //log.info(da.toString());
    }

    /**
     * @Description: 测试添加用户
     */
    @Test
    public void testSave() {
        User ts_user = new User("test",
                "test",
                "test@mail.com");
        userDao.save(ts_user);
        Assert.assertTrue(ts_user.getUserId() > 0);
    }

    /**
     * @Description: 测试逻辑删除
     */
    @Test
    //@Rollback(false)
    public void testDeleteByuserId() {
        int ts_userId = 14;
        userDao.deleteByUserId(ts_userId);
        Optional<User> byId = userDao.findById(ts_userId);
        Assert.assertEquals("1", byId.get().getIsdel());
    }
}
