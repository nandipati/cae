package com.rsi.adaptive.api.services;

import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.service.MLEAndSEServiceImpl;

import org.junit.Before;
import org.junit.Rule;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

/**
 * Created by suryadevarap on 1/30/19.
 */
public class MLEAndSEServiceTest {
  @Rule
  public MockitoRule mockitoRule = MockitoJUnit.rule();

  @InjectMocks
  private MLEAndSEService mleAndSEService = new MLEAndSEServiceImpl();

  @Before
  public void setUp(){
  }

  public void getStudentResponseTest(){

  }




}

