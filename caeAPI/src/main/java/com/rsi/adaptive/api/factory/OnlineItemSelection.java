package com.rsi.adaptive.api.factory;

import com.rsi.adaptive.api.controller.exception.NotFoundException;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;

/**
 * Created by suryadevarap on 2/6/19.
 */
public class OnlineItemSelection implements ItemSelection{
  @Override
  public NextItem getNextItem(double estimatedAbility,StudentRequestView requestView) {
    throw new NotFoundException(" Implementation is IN_PROGRESS ");
  }
}
