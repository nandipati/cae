package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/11/19.
 */
@Data
public class CurrentItemsDomain extends AbstractDomain {

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
