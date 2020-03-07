package com.reuben.springboot_demo;

import com.reuben.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootDemoApplicationTests {
    @Autowired
    private User user;
	@Test
	void contextLoads() {
		System.out.println("this is a test");
	}
	@Test
	void test_default_user(){
        System.out.println(user);
    }

}
