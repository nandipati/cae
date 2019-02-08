package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 1/11/19.
 */
@Data
public class NextItemDomain extends AbstractDomain {

  public String reference;
  public int organisationId;
  public String itemPoolId;
  public double discriminator;
  public double difficulty;

}
