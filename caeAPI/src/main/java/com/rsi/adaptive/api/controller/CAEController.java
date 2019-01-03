package com.rsi.adaptive.api.controller;

import com.rsi.adaptive.api.controller.enums.AdaptiveEndpoint;
import com.rsi.adaptive.api.controller.wrapper.InputFileWrapper;
import com.rsi.adaptive.api.service.MLEService;
import com.rsi.adaptive.api.utils.Constants;
import com.rsi.adaptive.api.view.InputResponse;
import com.rsi.adaptive.api.view.ItemResponses;
import com.rsi.adaptive.api.view.MLEAndSEResponseView;
import com.rsi.adaptive.api.view.MLEAndSEStudents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suryadevarap on 12/19/18.
 */
@RestController
@RequestMapping("v{" + Constants.VERSION_PARAM_NAME + "}/cae")
public class CAEController extends AbstractBaseController{

  @Autowired
  private MLEService service;

  @RequestMapping(value = "/MLE", method = RequestMethod.POST, produces = Constants.JSON, consumes = Constants.JSON)
  public MLEAndSEResponseView showResponse(
      @PathVariable(Constants.VERSION_PARAM_NAME) String versionNbr,
      @RequestParam boolean testMLE)
  {
    checkForVersion(versionNbr, AdaptiveEndpoint.ADAPTIVE_MLE);
    InputFileWrapper wrapper = new InputFileWrapper();
    InputResponse inputResponse= new InputResponse();


    if(testMLE) {
      inputResponse = wrapper.readTextFile();
    }

    return service.getMLEAndSE(wrapper.buildResponseVector(inputResponse));
  }


}
