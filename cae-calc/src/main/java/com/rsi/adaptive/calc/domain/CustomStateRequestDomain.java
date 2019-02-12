package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class CustomStateRequestDomain extends AbstractDomain {

  private String grade;
  private String subject;
  @JsonProperty("number_of_examine")
  private int NumberOfExamine;
  @JsonProperty("theta_range")
  private ThetaRangeDomain thetaRange;
  @JsonProperty("total_pool_items")
  private int totalPoolItems;
  @JsonProperty("IRTScalingValueD")
  private Double IRTScalingValueD;
  @JsonProperty("IRT_model")
  private String IRTModel;
  @JsonProperty("item_type")
  private String itemType;
  @JsonProperty("test_length")
  private TestLengthDomain testLength;
  @JsonProperty("score_estimation")
  private List<ScoreEstimationRequestDomain> scoreEstimation;
  @JsonProperty("previous_items")
  private List<PreviousItemsDomain> previousItems;

}
