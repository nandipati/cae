package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class PreviousItemsDomain extends AbstractDomain {

  private String reference;
  private double discriminator;
  private double difficulty;
}
