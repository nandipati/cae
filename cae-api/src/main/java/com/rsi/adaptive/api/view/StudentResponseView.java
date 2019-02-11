package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class StudentResponseView {

  @JsonProperty("next_items")
  private NextItem nextItem;
  @JsonProperty("is_last_items")
  private boolean lastItem;
  @JsonProperty("custom_state")
  private CustomStateResponse customStateResponse;

}
