package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/31/19.
 */
@Data
public class CustomStateResponse {
  @JsonProperty("estimations_for_previous")
  public Estimations estimatedAbility;

}
