package com.rsi.adaptive.api.service;

//import com.itemanalysis.psychometrics.data.VariableName;
//import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
//import com.itemanalysis.psychometrics.irt.model.Irm3PL;
//import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
// import com.rsi.adaptive.api.service.enums.ItemParameters;
import com.rsi.adaptive.api.mapper.DomainMapper;
import com.rsi.adaptive.api.view.TestStudentsResponseView;
import com.rsi.adaptive.api.view.TestStudents;
import com.rsi.adaptive.calc.service.MLEAndSECalcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Component
public class MLEAndSEServiceImpl implements MLEAndSEService {

  @Autowired
  private MLEAndSECalcService mleAndSECalcService;

  @Autowired
  private DomainMapper mapper;

  @Override
  public TestStudentsResponseView getMLEAndSE(byte[][] responseVector) {

    long startTime = System.nanoTime();

    TestStudentsResponseView testStudentsResponseView = new TestStudentsResponseView();
    List<TestStudents> testStudentsList;


    testStudentsList = mapper.convert(mleAndSECalcService.calculateMLEAndSEForAll(responseVector));


    testStudentsResponseView.setTestStudents(testStudentsList);

    long endTime   = System.nanoTime();
    long totalTime = endTime - startTime;

    System.out.println("totalTime in nanoseconds from service : "+ totalTime);
    double totalTimeInSec =(double)totalTime / 1_000_000_000.0;
    System.out.println("totalTime in seconds from service  : "+ totalTimeInSec);


    return testStudentsResponseView;
  }



}
