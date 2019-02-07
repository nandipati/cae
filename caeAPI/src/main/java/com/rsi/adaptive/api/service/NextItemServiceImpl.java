package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.factory.ItemSelection;
import com.rsi.adaptive.api.factory.ItemSelectionFactory;
import com.rsi.adaptive.api.mapper.DomainMapper;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.ScoreEstimationDomain;
import com.rsi.adaptive.calc.domain.ThetaRangeDomain;
import com.rsi.adaptive.calc.factory.AbilityEstimations;
import com.rsi.adaptive.calc.factory.AbilityFactory;
import com.rsi.adaptive.api.view.CustomStateResponse;
import com.rsi.adaptive.api.view.Estimations;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by suryadevarap on 2/5/19.
 */
@Component
public class NextItemServiceImpl implements NextItemService{


  @Autowired
  private DomainMapper mapper;

  @Override
  public StudentResponseView getNextItem(StudentRequestView requestView, String consumer) {

    Estimations estimations ;
    NextItem nextItem;
    StudentResponseView responseView = new StudentResponseView();
    CustomStateResponse customStateResponse = new CustomStateResponse();

    AbilityEstimations abilityEstimations = AbilityFactory.getClient(consumer);

    CustomStateRequestDomain customStateRequestDomain = buildCustomStateRequestDomainMapper(requestView);

    estimations = mapper.convert( abilityEstimations != null ? abilityEstimations.getEstimations(mapper.convertDomain(requestView.getCurrentItems())
        , customStateRequestDomain) : null);

    customStateResponse.setEstimatedAbility(estimations);

    ItemSelection itemSelection = ItemSelectionFactory.getClient(consumer);
    nextItem = itemSelection != null ? itemSelection.getNextItem(estimations.getEstimatedAbility(), requestView) : null;

    responseView.setNextItem(nextItem);
    responseView.setCustomStateResponse(customStateResponse);

    return responseView;
  }

  private CustomStateRequestDomain buildCustomStateRequestDomainMapper(StudentRequestView requestView) {

    ThetaRangeDomain thetaRangeDomain = mapper.convert(requestView.getCustomState().getThetaRange());

    List<ScoreEstimationDomain> scoreEstimationDomain = mapper.convertDomain(requestView.getCustomState()
        .getScoreEstimation());

    CustomStateRequestDomain customStateRequestDomain = mapper.convert(requestView.getCustomState());

    customStateRequestDomain.setThetaRange(thetaRangeDomain);
    customStateRequestDomain.setScoreEstimation(scoreEstimationDomain);

    return customStateRequestDomain;
  }

}
