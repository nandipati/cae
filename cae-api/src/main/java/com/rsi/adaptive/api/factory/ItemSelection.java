package com.rsi.adaptive.api.factory;

import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;

import org.springframework.stereotype.Component;

/**
 * Created by suryadevarap on 2/6/19.
 */
public interface ItemSelection {

  NextItem getNextItem(double estimatedAbility,StudentRequestView requestView);
}
