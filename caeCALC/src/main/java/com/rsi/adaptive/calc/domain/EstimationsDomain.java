package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 2/1/19.
 */
@Data
public class EstimationsDomain extends AbstractDomain {

  public double estimatedAbility;
  public String reference;
  public double mle;
  public double se;

}
