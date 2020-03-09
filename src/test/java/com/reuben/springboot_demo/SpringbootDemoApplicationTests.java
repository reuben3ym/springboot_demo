package com.reuben.springboot_demo;

import com.reuben.pojo.User;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringbootDemoApplicationTests {
    @Autowired
    private User user;
	@Test
	public void contextLoads() {
		System.out.println("this is a test");
	}
	@Test
	public void test_default_user(){
        System.out.println(user);
    }

}
