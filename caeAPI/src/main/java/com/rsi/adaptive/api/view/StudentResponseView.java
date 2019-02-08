package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class StudentResponseView {

  @JsonProperty("next_items")
  public NextItem nextItem;
  @JsonProperty("is_last_items")
  public boolean lastItem;
  @JsonProperty("custom_state")
  public CustomStateResponse customStateResponse;

}
