package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/31/19.
 */
@Data
public class Estimations extends AbstractView{
  private double estimatedAbility;
  private String reference;
  private double mle;
  private double se;
}
