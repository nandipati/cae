package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class CurrentItems extends AbstractView {

  private String reference;
  @JsonProperty("organisation_id")
  private String organisationId;
  @JsonProperty("item_pool_id")
  private String itemPoolId;
  private int score;
  @JsonProperty("max_score")
  private  int   maxScore;
  private double discriminator;
  private double difficulty;
}
