package com.rsi.adaptive.api.view;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class PreviousItem extends AbstractView {

  private String reference;
  private double discriminator;
  private double difficulty;

}
