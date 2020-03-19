package com.reuben.springboot_demo;



import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SpringbootDemoApplicationTests {

	@Before
	public void init(){
		System.out.println("start testing--------");
	}

	@After
	public void after(){
		System.out.println("End of test--------");
	}


}
