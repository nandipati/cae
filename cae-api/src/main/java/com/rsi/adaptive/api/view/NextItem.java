package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class NextItem extends AbstractView {

  private String reference;
  private int organisationId;
  private String itemPoolId;
  private double discriminator;
  private double difficulty;
}
