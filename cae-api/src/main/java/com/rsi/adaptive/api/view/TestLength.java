package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 1/29/19.
 */
@Data
public class TestLength extends AbstractView{

  @JsonProperty("total_items")
  private int totalItems;
  @JsonProperty("total_passages")
  private int totalPassages;

}
