package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class NextItem extends AbstractView {

  public String reference;
  public int organisationId;
  public String itemPoolId;
  public double discriminator;
  public double difficulty;
}
