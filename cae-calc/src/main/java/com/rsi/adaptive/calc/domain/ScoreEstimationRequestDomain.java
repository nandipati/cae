package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rsi.adaptive.calc.enums.EstimatedMethod;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class ScoreEstimationRequestDomain extends AbstractDomain {

  @JsonProperty("estimation_type")
  private EstimatedMethod estimationMethod;
  @JsonProperty("test_type")
  private String testType;
  @JsonProperty("interim_range")
  private InterimRangesDomain interimRanges;
}
