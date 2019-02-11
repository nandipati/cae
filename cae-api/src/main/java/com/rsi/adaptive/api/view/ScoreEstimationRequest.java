package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rsi.adaptive.calc.enums.EstimatedMethod;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class ScoreEstimationRequest extends AbstractView {

  @JsonProperty("estimation_type")
  private EstimatedMethod estimationMethod;
  @JsonProperty("test_type")
  private String testType;
  @JsonProperty("interim_range")
  private InterimRanges interimRanges;
}
