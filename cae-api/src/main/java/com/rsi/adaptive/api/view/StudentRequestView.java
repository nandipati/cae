package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class StudentRequestView extends AbstractView{

  @JsonProperty("session_id")
  @NotNull
  private String sessionId;
  @JsonProperty("adaptive_activity")
  @Valid
  @NotNull
  private AdaptiveActivity adaptiveActivity;
  @JsonProperty("current_items")
  private List<CurrentItems> currentItems;
  @JsonProperty("custom_state")
  private CustomStateRequest customState;

}
