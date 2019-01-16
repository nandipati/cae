package com.rsi.adaptive.calc.domain;

import lombok.Data;

/**
 * Created by suryadevarap on 1/11/19.
 */
@Data
public class CurrentItemsDomain extends AbstractDomain {

  public String reference;
  public String organisationId;
  public String itemPoolId;
  public double score;
  public  int   maxScore;
  public int itemResponse;
  public double discriminator;
  public double difficulty;

}
