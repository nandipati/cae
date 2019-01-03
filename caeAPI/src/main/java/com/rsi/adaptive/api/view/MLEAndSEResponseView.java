package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Data
public class MLEAndSEResponseView {

  @JsonProperty("students")
  private List<MLEAndSEStudents> mleAndSEStudents;

}
