package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.controller.exception.NotFoundException;
import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.stereotype.Component;

/**
 * Created by suryadevarap on 1/15/19.
 */
@Component
public class Online implements Item {

  @Override
  public StudentResponseView firstItem(StudentRequestView requestView) {
     throw new NotFoundException(" Implementation is IN_PROGRESS ");
  }

  @Override
  public StudentResponseView nextItem(StudentRequestView requestView) {
    throw new NotFoundException(" Implementation is IN_PROGRESS ");
  }
}
