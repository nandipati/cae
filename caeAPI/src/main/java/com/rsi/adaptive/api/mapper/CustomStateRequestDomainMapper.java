package com.rsi.adaptive.api.mapper;

import com.rsi.adaptive.api.view.AbstractView;
import com.rsi.adaptive.api.view.CustomStateRequest;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.ScoreEstimationDomain;
import com.rsi.adaptive.calc.domain.ThetaRangeDomain;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Component
public class CustomStateRequestDomainMapper implements DomainViewMapper<CustomStateRequestDomain,CustomStateRequest>{

  @Autowired
  private DomainMapper mapper;

  public CustomStateRequest convert(CustomStateRequestDomain domain) {
    CustomStateRequest view = new CustomStateRequest();
    BeanUtils.copyProperties(domain, view);
    return view;
  }

  public CustomStateRequestDomain convert(CustomStateRequest view) {

    CustomStateRequestDomain domain ;
    ThetaRangeDomain thetaRangeDomain = mapper.convert(view.getThetaRange());
    List<ScoreEstimationDomain> scoreEstimationDomain = mapper.convertDomain(view.getScoreEstimation());
    domain = mapper.convert(view);

    domain.setThetaRange(thetaRangeDomain);
    domain.setScoreEstimation(scoreEstimationDomain);

    return domain;
  }

  @Override
  public boolean supports(Class<? extends AbstractView> clazz) {
    return CustomStateRequestDomain.class.equals(clazz);
  }
}
