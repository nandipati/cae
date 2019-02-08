package com.rsi.adaptive.calc.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.Data;

/**
 * Created by suryadevarap on 1/7/19.
 */
@Data
public class TestStudentsDomain extends AbstractDomain {

  public String studentName;

  @JsonProperty(value = "itemResponsesList", access = JsonProperty.Access.WRITE_ONLY)
  public List<ItemResponsesDomain> itemResponsesList;

  public double MLE;

  public double SE;

}
