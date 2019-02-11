package com.rsi.adaptive.api.services;

import com.rsi.adaptive.api.service.NextItemService;
import com.rsi.adaptive.api.service.NextItemServiceImpl;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Created by suryadevarap on 1/30/19.
 */
public class NextItemServiceTest {
  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @InjectMocks
  private NextItemService mleAndSEService = new NextItemServiceImpl();

  @Before
  public void setUp(){
  }

  public void getStudentResponseTest(){

  }

}

