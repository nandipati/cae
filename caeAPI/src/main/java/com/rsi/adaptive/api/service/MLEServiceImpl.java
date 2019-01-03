package com.rsi.adaptive.api.service;

import com.itemanalysis.psychometrics.data.VariableName;
import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
import com.itemanalysis.psychometrics.irt.model.Irm3PL;
import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
import com.rsi.adaptive.api.service.enums.ItemParameters;
import com.rsi.adaptive.api.view.ItemResponses;
import com.rsi.adaptive.api.view.MLEAndSEResponseView;
import com.rsi.adaptive.api.view.MLEAndSEStudents;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suryadevarap on 12/21/18.
 */
@Component
public class MLEServiceImpl implements MLEService {

  @Override
  public MLEAndSEResponseView getMLEAndSE(byte[][] responseVector) {

    MLEAndSEResponseView mleAndSEResponseView = new MLEAndSEResponseView();
    List<MLEAndSEStudents> mleAndSEStudentsList = new ArrayList<>();
    MLEAndSEStudents mleAndSEStudents;

    int n = ItemParameters.DISCRIMINATOR.getParam().length;
    ItemParameters disc = ItemParameters.DISCRIMINATOR;
    ItemParameters diff = ItemParameters.DIFFICULTY;
    int nPeople = responseVector.length;

    ItemResponseModel[] irmArray = new ItemResponseModel[n];

    VariableName iName;
    for(int i=0;i<n;i++){
      String name = "V"+i;
      iName = new VariableName(name);

      irmArray[i] = new Irm3PL(disc.getParam()[i], diff.getParam()[i],  1.7);
      irmArray[i].setName(iName);
    }


    IrtExaminee iVec = new IrtExaminee(irmArray);

    double mle;
    double se ;
    for(int j=0;j<nPeople;j++) {
      mleAndSEStudents = new MLEAndSEStudents();

      iVec.setResponseVector(responseVector[j]);

      mle = iVec.maximumLikelihoodEstimate(-6.0, 6.0);
      se = iVec.mleStandardErrorAt(mle);
      mleAndSEStudents.setStudentName("Student "+(j+1));
      mleAndSEStudents.setMLE(mle);
      mleAndSEStudents.setSE(se);
      mleAndSEStudentsList.add(mleAndSEStudents);
    }

     mleAndSEResponseView.setMleAndSEStudents(mleAndSEStudentsList);



    return mleAndSEResponseView;
  }



}
