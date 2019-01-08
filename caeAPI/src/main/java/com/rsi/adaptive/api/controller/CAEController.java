package com.rsi.adaptive.api.controller;

import com.rsi.adaptive.api.controller.enums.AdaptiveEndpoint;
import com.rsi.adaptive.api.controller.wrapper.InputFileWrapper;
import com.rsi.adaptive.api.service.MLEService;
import com.rsi.adaptive.api.utils.Constants;
import com.rsi.adaptive.api.view.InputResponse;
import com.rsi.adaptive.api.view.TestStudentsResponseView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
  private MLEService service;

  /* General test case restCall for a given responseVector */
  @RequestMapping(value = "/testResponse", method = RequestMethod.POST, produces = Constants.JSON,
                  consumes = Constants.JSON)
  public TestStudentsResponseView showResponse(
      @PathVariable(Constants.VERSION_PARAM_NAME) String versionNbr,
      @RequestParam boolean test)
  {
    long startTime = System.nanoTime();
    TestStudentsResponseView view = new TestStudentsResponseView();
    checkForVersion(versionNbr, AdaptiveEndpoint.ADAPTIVE_MLE);
    InputFileWrapper wrapper = new InputFileWrapper();
    InputResponse inputResponse= new InputResponse();


    if(test) {
      inputResponse = wrapper.readTextFile();
    }

    view = service.getMLEAndSE(wrapper.buildResponseVector(inputResponse));

    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;
    System.out.println("totalTime in nanoseconds from controller : "+ totalTime);
    double totalTimeInSec =(double)totalTime / 1_000_000_000.0;
    System.out.println("totalTime in seconds from controller  : "+ totalTimeInSec);

    return view;

  }


}
