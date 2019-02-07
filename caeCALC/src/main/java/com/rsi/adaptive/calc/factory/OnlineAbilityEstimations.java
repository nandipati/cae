package com.rsi.adaptive.calc.factory;

import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.EstimationsDomain;
import com.rsi.adaptive.calc.exception.NotFoundException;

import java.util.List;

/**
 * Created by suryadevarap on 2/6/19.
 */
public class OnlineAbilityEstimations implements AbilityEstimations{

  @Override
  public EstimationsDomain getEstimations(List<CurrentItemsDomain> currentItems,
      CustomStateRequestDomain customStateRequestDomain) {
    throw new NotFoundException(" Implementation is IN_PROGRESS ");
  }
}
