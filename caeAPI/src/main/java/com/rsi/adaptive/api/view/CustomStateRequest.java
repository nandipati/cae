package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class CustomStateRequest {

   public String grade;
   public String subject;
   @JsonProperty("theta_range")
   public ThetaRange thetaRange;
   @JsonProperty("total_pool_items")
   public int totalPoolItems;
   @JsonProperty("scaling")
   public Double D;
   @JsonProperty("IRT_model")
   public String IRT_model;
   @JsonProperty("item_type")
   public String itemType;
   @JsonProperty("test_length")
   public TestLength testLength;
   @JsonProperty("score_estimation")
   public List<ScoreEstimation> scoreEstimation;
   @JsonProperty("previous_items")
   public List<PreviousItems> previousItems;
}
