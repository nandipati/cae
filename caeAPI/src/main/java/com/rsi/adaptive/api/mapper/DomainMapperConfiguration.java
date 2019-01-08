package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.TestStudents;
import com.rsi.adaptive.calc.domain.MLEAndSEStudentsDomain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by suryadevarap on 1/8/19.
 */
@Configuration
public class DomainMapperConfiguration {

  @Bean
  public DomainMapper domainMapper(){
    GenericDomainMapperImpl mapper = new GenericDomainMapperImpl();

    mapper.addClassMapping( MLEAndSEStudentsDomain.class,TestStudents.class);

    return mapper;
  }

}
