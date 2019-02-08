package com.rsi.adaptive.calc.factory;

import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.EstimationsDomain;

import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Component
public interface AbilityEstimations {

  EstimationsDomain getEstimations(List<CurrentItemsDomain> currentItems,CustomStateRequestDomain customStateRequestDomain);
}
