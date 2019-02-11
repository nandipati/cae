package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * Created by suryadevarap on 1/10/19.
 */
@Data
public class AdaptiveActivity {

  @JsonProperty("student_id")
  @NotNull
  private String studentId;
  @JsonProperty("activity_id")
  @NotNull
  private String activityId;

}
