package com.rsi.adaptive.api.view;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by suryadevarap on 1/8/19.
 */
public class AbstractView {
  @JsonIgnore
  private String version;

  public String getVersion() {
    return version;
  }

  public void setVersion(String version) {
    this.version = version;
  }
}
