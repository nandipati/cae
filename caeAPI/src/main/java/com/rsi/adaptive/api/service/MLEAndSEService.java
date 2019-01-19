package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;
import com.rsi.adaptive.api.view.TestStudentsResponseView;

/**
 * Created by suryadevarap on 12/21/18.
 */
public interface MLEAndSEService {

  TestStudentsResponseView getMLEAndSE(byte[][] responseVector);

  StudentResponseView getNextItem(StudentRequestView requestView, String consumer);

}
