package com.reuben.springboot_demo.pojo;

import com.reuben.pojo.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: springboot_demo
 * @description: User unit tests
 * @author: reuben
 **/
@Slf4j
public class UserTests extends SpringbootDemoApplicationTests {

    @Autowired
    private User user_default;

    @Test
    public void test_toString(){
        log.info(user_default.toString());
    }
}
