package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.view.TestStudentsResponseView;

/**
 * Created by suryadevarap on 12/21/18.
 */
public interface MLEService {

  TestStudentsResponseView getMLEAndSE(byte[][] responseVector);
}
