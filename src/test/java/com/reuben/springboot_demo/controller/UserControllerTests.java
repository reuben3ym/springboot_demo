package com.reuben.springboot_demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.reuben.pojo.User;
import com.reuben.springboot_demo.SpringbootDemoApplicationTests;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

/**
 * @description:
 **/
@Slf4j
@Transactional
public class UserControllerTests extends SpringbootDemoApplicationTests {


    private ObjectMapper mapper = new ObjectMapper();//jackson

    private MockHttpServletRequestBuilder content = null;//构造请求

    //json格式的User
    private static String user_json;

    {
        try {
            user_json = mapper.writeValueAsString(new User("test", "test", "test@mail.cn"));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    @SneakyThrows
    @Test
    public void test_testPost() {
        content = MockMvcRequestBuilders.post("/testPost")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(user_json);
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());

    }

    @SneakyThrows
    @Test
    public void test_getDefaultUser() {
        String contentAsString = mvc.perform(MockMvcRequestBuilders.get("/getDefaultUser"))
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn().getResponse().getContentAsString();
        log.info(contentAsString);
    }

    @SneakyThrows
    @Test
    public void test_addUser() {
        content = MockMvcRequestBuilders.post("/addUser")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(user_json);
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @SneakyThrows
    @Test
    public void test_getAllUser() {
        content = MockMvcRequestBuilders.get("/getAllUser")
                .contentType(MediaType.APPLICATION_JSON_UTF8);
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @SneakyThrows
    @Test
    public void test_findByUserName() {
        String userName = "da";
        content = MockMvcRequestBuilders.post("/findByUserName")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(userName));
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());

    }

    @SneakyThrows
    @Test
    public void test_deleUserById() {
        int id = 1;
        MockHttpServletRequestBuilder content = MockMvcRequestBuilders.post("/deleteUserById")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(id));
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());

    }

    @SneakyThrows
    @Test
    public void test_update() {
        User user = new User();
        user.setUserId(1);
        user.setUserName("test");
        user.setUserPassword("test");
        user.setEmail("test@mail.cn");

        content = MockMvcRequestBuilders.post("/update")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(mapper.writeValueAsBytes(user));
        MvcResult mvcResult = mvc.perform(content).andReturn();
        log.info(mvcResult.getResponse().getContentAsString());

    }
}
