package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class StudentRequestView extends AbstractView{

  @JsonProperty("session_id")
  public String sessionId;
  @JsonProperty("adaptive_activity")
  public AdaptiveActivity adaptiveActivity;
  @JsonProperty("current_items")
  public List<CurrentItems> currentItems;
  @JsonProperty("custom_state")
  public CustomStateRequest customState;

}
