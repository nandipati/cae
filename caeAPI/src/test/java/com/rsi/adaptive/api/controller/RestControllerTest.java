package com.rsi.adaptive.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rsi.adaptive.api.CAEApplication;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by suryadevarap on 1/30/19.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CAEApplication.class)
@ComponentScan
@TestPropertySource(locations = "classpath:testConfig/application-testcase.properties")
@WebAppConfiguration
public abstract class RestControllerTest {

  protected MockMvc mockMvc;

  protected ObjectMapper objectMapper;

  @Autowired
  protected WebApplicationContext webApplicationContext;

  protected static ApplicationContext ctx;

  @Autowired
  public void setApplicationContext(ApplicationContext ctx) {
    RestControllerTest.ctx = ctx;
  }

  @Before
  public final void before() {
    mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    objectMapper = new ObjectMapper();
    objectMapper.findAndRegisterModules();
  }
}
