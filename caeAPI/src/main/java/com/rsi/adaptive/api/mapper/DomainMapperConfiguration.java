package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.TestStudents;
import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.NextItemDomain;
import com.rsi.adaptive.calc.domain.TestStudentsDomain;

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

    mapper.addClassMapping( TestStudentsDomain.class,TestStudents.class);
    mapper.addClassMapping(CurrentItemsDomain.class,CurrentItems.class);
    mapper.addClassMapping(NextItemDomain.class, NextItem.class);

    return mapper;
  }

}
