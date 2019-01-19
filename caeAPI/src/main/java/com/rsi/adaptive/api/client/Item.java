package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.stereotype.Component;

/**
 * Created by suryadevarap on 1/15/19.
 */
public interface Item {

  StudentResponseView firstItem(StudentRequestView requestView);

  StudentResponseView nextItem(StudentRequestView requestView);

}
