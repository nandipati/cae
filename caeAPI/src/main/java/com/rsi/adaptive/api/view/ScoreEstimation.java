package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rsi.adaptive.calc.enums.EstimatedMethod;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class ScoreEstimation extends AbstractView {

  @JsonProperty("estimation_type")
  public EstimatedMethod estimationMethod;
  @JsonProperty("test_type")
  public String testType;
  @JsonProperty("interim_range")
  public InterimRanges interimRanges;
}
