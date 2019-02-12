package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Data
public class TestLengthDomain extends AbstractDomain {


  @JsonProperty("total_items")
  private int totalItems;
  @JsonProperty("total_passages")
  private int totalPassages;

}
