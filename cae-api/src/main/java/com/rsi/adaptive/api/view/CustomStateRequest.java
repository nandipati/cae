package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class CustomStateRequest extends AbstractView {

   private String grade;
   private String subject;
   @JsonProperty("number_of_examine")
   private int NumberOfExamine;
   @JsonProperty("theta_range")
   private ThetaRange thetaRange;
   @JsonProperty("total_pool_items")
   private int totalPoolItems;
   @JsonProperty("IRTScalingValueD")
   private Double IRTScalingValueD;
   @JsonProperty("IRT_model")
   private String IRTModel;
   @JsonProperty("item_type")
   private String itemType;
   @JsonProperty("test_length")
   private TestLength testLength;
   @JsonProperty("score_estimation")
   private List<ScoreEstimationRequest> scoreEstimation;
   @JsonProperty("previous_items")
   private List<PreviousItem> previousItems;
}
