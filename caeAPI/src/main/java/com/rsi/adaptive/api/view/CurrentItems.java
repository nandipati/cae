package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class CurrentItems extends AbstractView {

  public String reference;
  @JsonProperty("organisation_id")
  public String organisationId;
  @JsonProperty("item_pool_id")
  public String itemPoolId;
  public int score;
  @JsonProperty("max_score")
  public  int   maxScore;
  public double discriminator;
  public double difficulty;
}
