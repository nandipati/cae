package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.UUID;

import lombok.Data;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Data
public class TestStudents extends AbstractView {

  private String studentName;

  @JsonProperty( value = "itemResponsesList", access = JsonProperty.Access.WRITE_ONLY)
  private List<ItemResponses> itemResponsesList;

  private double MLE;

  private double SE;

}
