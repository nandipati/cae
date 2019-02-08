package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class AdaptiveActivity {

  @JsonProperty("student_id")
  public String studentId;
  @JsonProperty("activity_id")
  public String activityId;

}
