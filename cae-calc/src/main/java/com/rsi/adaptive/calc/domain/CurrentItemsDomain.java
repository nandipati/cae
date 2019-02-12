package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/11/19.
 */
@Data
public class CurrentItemsDomain extends AbstractDomain {

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
