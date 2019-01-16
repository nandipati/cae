package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class CurrentItems extends AbstractView {

  public String reference;
  public String organisationId;
  public String itemPoolId;
  public double score;
  public  int   maxScore;
  public int itemResponse;
  public double discriminator;
  public double difficulty;
}
