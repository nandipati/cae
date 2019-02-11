package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 1/11/19.
 */
@Data
public class NextItemDomain extends AbstractDomain {

  private String reference;
  private int organisationId;
  private String itemPoolId;
  private double discriminator;
  private double difficulty;

}
