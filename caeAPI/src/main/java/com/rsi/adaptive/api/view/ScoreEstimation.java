package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class ScoreEstimation {

  @JsonProperty("estimation_type")
  public String estimationType;
  @JsonProperty("test_type")
  public String testType;
  @JsonProperty("interim_range")
  public InterimRanges interimRanges;
}
