package com.rsi.adaptive.api.service;

import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

/**
 * Created by suryadevarap on 2/5/19.
 */
public interface NextItemService {

  StudentResponseView getNextItem(StudentRequestView requestView, String consumer);
}
