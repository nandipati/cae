package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Data
public class MLEAndSEStudents {

  private String studentName;

  @JsonProperty( value = "itemResponsesList", access = JsonProperty.Access.WRITE_ONLY)
  private List<ItemResponses> itemResponsesList;

  private double MLE;

  private double SE;

}
