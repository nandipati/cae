package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 2/1/19.
 */
@Data
public class EstimationsDomain extends AbstractDomain {

  private double estimatedAbility;
  private String reference;
  private double mle;
  private double se;

}
