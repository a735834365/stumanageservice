package com.team.service;

import com.team.StumanageApplication;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * create by yifeng
 */
public class UserServiceTest extends StumanageApplication {

    //伪造一个mvc环境
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        mockMvc  = MockMvcBuilders.webAppContextSetup(wac).build();
    }



}
