package com.rsi.adaptive.api.services;

import com.rsi.adaptive.api.service.NextItemService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import static org.mockito.Mockito.mock;

/**
 * Created by suryadevarap on 1/30/19.
 */
@Configuration
public class MockServiceConfig {

  @Bean
  @Primary
  public NextItemService mleAndSEService(){
    return mock(NextItemService.class);
  }

}
