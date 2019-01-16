package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by suryadevarap on 1/15/19.
 */
public class Simulation implements Client{

  @Override
  public StudentResponseView clientCall(StudentRequestView requestView,MLEAndSEService mleAndSEService) {
    StudentResponseView responseView = new StudentResponseView();

    NextItem nextItem ;

    if (requestView.currentItems.getReference()!=null)
    {
      nextItem= mleAndSEService.getByAbility(requestView);
    }else{
      // for the first item
      nextItem= mleAndSEService.getByGrade(requestView.getGrade());
    }
    responseView.setNextItem(nextItem);

    return responseView;
  }
}
