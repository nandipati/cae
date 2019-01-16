package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class StudentRequestView extends AbstractView{

  public String sessionId;
  public AdaptiveActivity adaptiveActivity;
  @JsonProperty("current_items")
  public CurrentItems currentItems;
  public int grade;

}
