package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rsi.adaptive.calc.enums.EstimatedMethod;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class ScoreEstimationDomain extends AbstractDomain {

  @JsonProperty("estimation_type")
  public EstimatedMethod estimationMethod;
  @JsonProperty("test_type")
  public String testType;
  @JsonProperty("interim_range")
  public InterimRangesDomain interimRanges;
}
