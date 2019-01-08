package com.rsi.adaptive.api.service;

//import com.itemanalysis.psychometrics.data.VariableName;
//import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
//import com.itemanalysis.psychometrics.irt.model.Irm3PL;
//import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
// import com.rsi.adaptive.api.service.enums.ItemParameters;
import com.rsi.adaptive.api.mapper.DomainMapper;
import com.rsi.adaptive.api.view.MLEAndSEResponseView;
import com.rsi.adaptive.api.view.MLEAndSEStudents;
import com.rsi.adaptive.calc.service.MLEAndSECalcService;
import com.rsi.adaptive.calc.service.MLEAndSEWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Component
public class MLEServiceImpl implements MLEService {

  @Autowired
  private MLEAndSECalcService mleAndSECalcService;

  @Autowired
  private DomainMapper mapper;

  @Override
  public MLEAndSEResponseView getMLEAndSE(byte[][] responseVector) {

    long startTime = System.nanoTime();

    MLEAndSEResponseView mleAndSEResponseView = new MLEAndSEResponseView();
    List<MLEAndSEStudents> mleAndSEStudentsList;


    mleAndSEStudentsList = mapper.convert(mleAndSECalcService.calculateMLEAndSEForAll(responseVector));


    mleAndSEResponseView.setMleAndSEStudents(mleAndSEStudentsList);

    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;

    System.out.println("totalTime in nanoseconds from service : "+ totalTime);
    double totalTimeInSec =(double)totalTime / 1_000_000_000.0;
    System.out.println("totalTime in seconds from service  : "+ totalTimeInSec);


    return mleAndSEResponseView;
  }



}
