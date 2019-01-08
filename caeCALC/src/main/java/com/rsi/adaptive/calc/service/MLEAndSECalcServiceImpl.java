package com.rsi.adaptive.calc.service;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.itemanalysis.psychometrics.data.VariableName;
import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
import com.itemanalysis.psychometrics.irt.model.Irm3PL;
import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
import com.rsi.adaptive.calc.domain.MLEAndSEStudentsDomain;
import com.rsi.adaptive.calc.enums.ItemParameters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suryadevarap on 1/7/19.
 */
@Service
public class MLEAndSECalcServiceImpl implements MLEAndSECalcService {


  @Override
  public List<MLEAndSEStudentsDomain> calculateMLEAndSEForAll(byte[][] responseVector) {

    List<MLEAndSEStudentsDomain> mleAndSEStudentsList = new ArrayList<>();
    MLEAndSEStudentsDomain mleAndSEStudents;

    int numberOfItems = ItemParameters.DISCRIMINATOR.getParam().length;
    ItemParameters disc = ItemParameters.DISCRIMINATOR;
    ItemParameters diff = ItemParameters.DIFFICULTY;
    int nPeople = responseVector.length;

    ItemResponseModel[] irmArray = new ItemResponseModel[numberOfItems];

    VariableName iName;
    for(int i=0;i<numberOfItems;i++){
      String name = "V"+i;
      iName = new VariableName(name);

      irmArray[i] = new Irm3PL(disc.getParam()[i], diff.getParam()[i],  1.7);
      irmArray[i].setName(iName);
    }


    IrtExaminee  iVec = new IrtExaminee(irmArray);

    for(int j=0;j<nPeople;j++) {
      double mle;
      double se ;

      mleAndSEStudents = new MLEAndSEStudentsDomain();

      iVec.setResponseVector(responseVector[j]);

      mle = iVec.maximumLikelihoodEstimate(-6.0, 6.0);
      se = iVec.mleStandardErrorAt(mle);
      mleAndSEStudents.setStudentName("Student "+(j+1));
      mleAndSEStudents.setMLE(mle);
      mleAndSEStudents.setSE(se);
      mleAndSEStudentsList.add(mleAndSEStudents);
    }

    return mleAndSEStudentsList;
  }



}
