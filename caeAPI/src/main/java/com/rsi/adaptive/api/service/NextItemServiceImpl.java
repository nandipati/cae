package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.factory.ItemSelection;
import com.rsi.adaptive.api.factory.ItemSelectionFactory;
import com.rsi.adaptive.api.mapper.CustomStateRequestDomainMapper;
import com.rsi.adaptive.api.mapper.DomainMapper;
import com.rsi.adaptive.calc.factory.AbilityEstimations;
import com.rsi.adaptive.calc.factory.AbilityFactory;
import com.rsi.adaptive.api.view.CustomStateResponse;
import com.rsi.adaptive.api.view.Estimations;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * Created by suryadevarap on 2/5/19.
 */
@Component
public class NextItemServiceImpl implements NextItemService{


  @Autowired
  private DomainMapper mapper;

  @Autowired
  private CustomStateRequestDomainMapper customStateMapper;

  @Override
  public StudentResponseView getNextItem(StudentRequestView requestView, String consumer) {

    Estimations estimations ;
    NextItem nextItem;
    StudentResponseView responseView = new StudentResponseView();
    CustomStateResponse customStateResponse = new CustomStateResponse();

    AbilityEstimations abilityEstimations = AbilityFactory.getClient(consumer);

    estimations = mapper.convert( abilityEstimations != null ?
        abilityEstimations.getEstimations(mapper.convertDomain(requestView.getCurrentItems()),
            customStateMapper.convert(requestView.getCustomState())) : null);

    customStateResponse.setEstimatedAbility(estimations);

    ItemSelection itemSelection = ItemSelectionFactory.getClient(consumer);
    nextItem = itemSelection != null ? itemSelection.getNextItem(estimations.getEstimatedAbility(), requestView) : null;

    responseView.setNextItem(nextItem);
    responseView.setCustomStateResponse(customStateResponse);

    return responseView;
  }

}
