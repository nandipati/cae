package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.view.MLEAndSEResponseView;

import java.util.List;

/**
 * Created by suryadevarap on 12/21/18.
 */
public interface MLEService {

  MLEAndSEResponseView getMLEAndSE(byte[][] responseVector);
}
