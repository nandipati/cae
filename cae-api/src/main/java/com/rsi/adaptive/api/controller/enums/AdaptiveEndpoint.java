package com.rsi.adaptive.api.controller.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Created by suryadevarap on 12/20/18.
 */
public enum AdaptiveEndpoint {

  ADAPTIVE_MLE(SupportedVersion.V1);

  private final List<SupportedVersion> supportedVersions;

  public List<SupportedVersion> getSupportedVersions() {
    return supportedVersions;
  }

  AdaptiveEndpoint(SupportedVersion... supportedVersions ) {
    this.supportedVersions= Arrays.asList(supportedVersions);
  }
}
