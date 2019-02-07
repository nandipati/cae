package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class CustomStateRequestDomain extends AbstractDomain {

  public String grade;
  public String subject;
  @JsonProperty("number_of_examine")
  public int NumberOfExamine;
  @JsonProperty("theta_range")
  public ThetaRangeDomain thetaRange;
  @JsonProperty("total_pool_items")
  public int totalPoolItems;
  @JsonProperty("IRTScalingValueD")
  public Double IRTScalingValueD;
  @JsonProperty("IRT_model")
  public String IRTModel;
  @JsonProperty("item_type")
  public String itemType;
  @JsonProperty("test_length")
  public TestLengthDomain testLength;
  @JsonProperty("score_estimation")
  public List<ScoreEstimationDomain> scoreEstimation;
  @JsonProperty("previous_items")
  public List<PreviousItemsDomain> previousItems;

}
