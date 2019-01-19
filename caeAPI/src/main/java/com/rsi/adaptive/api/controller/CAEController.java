package com.rsi.adaptive.api.controller;

import com.rsi.adaptive.api.client.Item;
import com.rsi.adaptive.api.client.ItemFactory;
import com.rsi.adaptive.api.controller.enums.AdaptiveEndpoint;
import com.rsi.adaptive.api.controller.wrapper.InputFileWrapper;
import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.utils.Constants;
import com.rsi.adaptive.api.view.InputResponse;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;
import com.rsi.adaptive.api.view.TestStudentsResponseView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by suryadevarap on 12/19/18.
 */
@RestController
@RequestMapping("v{" + Constants.VERSION_PARAM_NAME + "}/cae")
public class CAEController extends AbstractBaseController{

  @Autowired
  private MLEAndSEService mleAndSEService;

  /* General test-case restCall for a given responseVector */
  @RequestMapping(value = "/testResponse", method = RequestMethod.POST, produces = Constants.JSON,
                  consumes = Constants.JSON)
  public TestStudentsResponseView showResponse(
      @PathVariable(Constants.VERSION_PARAM_NAME) String versionNbr,
      @RequestParam boolean test)
  {
    long startTime = System.nanoTime();
    TestStudentsResponseView view ;
    checkForVersion(versionNbr, AdaptiveEndpoint.ADAPTIVE_MLE);
    InputFileWrapper wrapper = new InputFileWrapper();
    InputResponse inputResponse= new InputResponse();

    if(test) {
      inputResponse = wrapper.readTextFile();
    }

    view = mleAndSEService.getMLEAndSE(wrapper.buildResponseVector(inputResponse));

    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println("totalTime in nanoseconds from controller : "+ totalTime);
    double totalTimeInSec =(double)totalTime / 1_000_000_000.0;
    System.out.println("totalTime in seconds from controller  : "+ totalTimeInSec);

    return view;

  }

  @RequestMapping(value = "/quiz", method = RequestMethod.POST, produces = Constants.JSON, consumes = Constants.JSON)
  public StudentResponseView quiz(
      @PathVariable(Constants.VERSION_PARAM_NAME) String versionNbr,
      @RequestParam(value = "consumer",required = false, defaultValue = "online") String consumer,
      @RequestBody StudentRequestView requestView){

       return mleAndSEService.getNextItem(requestView,consumer);

  }

}
