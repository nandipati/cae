package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/31/19.
 */
@Data
public class EstimatedAbility {
  public String reference;
  public double mle;
  public double se;
}
