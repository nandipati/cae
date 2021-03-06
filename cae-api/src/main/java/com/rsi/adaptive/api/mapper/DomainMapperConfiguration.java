package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.CustomStateRequest;
import com.rsi.adaptive.api.view.Estimations;
import com.rsi.adaptive.api.view.InterimRanges;
import com.rsi.adaptive.api.view.PreviousItem;
import com.rsi.adaptive.api.view.ScoreEstimationRequest;
import com.rsi.adaptive.api.view.TestLength;
import com.rsi.adaptive.api.view.TestStudents;
import com.rsi.adaptive.api.view.ThetaRange;
import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.EstimationsDomain;
import com.rsi.adaptive.calc.domain.InterimRangesDomain;
import com.rsi.adaptive.calc.domain.PreviousItemsDomain;
import com.rsi.adaptive.calc.domain.ScoreEstimationRequestDomain;
import com.rsi.adaptive.calc.domain.TestLengthDomain;
import com.rsi.adaptive.calc.domain.TestStudentsDomain;
import com.rsi.adaptive.calc.domain.ThetaRangeDomain;

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
    mapper.addClassMapping( EstimationsDomain.class,Estimations.class);
    mapper.addDomainClassMapping( CurrentItems.class,CurrentItemsDomain.class);
    mapper.addClassMapping( CustomStateRequestDomain.class,CustomStateRequest.class);
    mapper.addDomainClassMapping(CustomStateRequest.class, CustomStateRequestDomain.class);
    mapper.addClassMapping( ScoreEstimationRequestDomain.class,ScoreEstimationRequest.class);
    mapper.addDomainClassMapping( ScoreEstimationRequest.class,ScoreEstimationRequestDomain.class);
    mapper.addClassMapping( ThetaRangeDomain.class,ThetaRange.class);
    mapper.addClassMapping( TestLengthDomain.class,TestLength.class);
    mapper.addClassMapping( PreviousItemsDomain.class,PreviousItem.class);
    mapper.addClassMapping( InterimRangesDomain.class,InterimRanges.class);
    return mapper;
  }

}
