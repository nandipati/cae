package com.rsi.adaptive.calc.service;

import com.itemanalysis.psychometrics.data.VariableName;
import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
import com.itemanalysis.psychometrics.irt.model.Irm3PL;
import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
import com.itemanalysis.psychometrics.optimization.SloppyMath;
import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.NextItemDomain;
import com.rsi.adaptive.calc.domain.TestStudentsDomain;
import com.rsi.adaptive.calc.enums.ItemParameters;
import com.rsi.adaptive.calc.math.CALCUtils;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by suryadevarap on 1/7/19.
 */
@Component
public class MLEAndSECalcServiceImpl implements MLEAndSECalcService {

  @Override
  public List<TestStudentsDomain> calculateMLEAndSEForAll(byte[][] responseVector) {

    List<TestStudentsDomain> mleAndSEStudentsList = new ArrayList<>();
    TestStudentsDomain testStudentsDomain;

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

      testStudentsDomain = new TestStudentsDomain();

      iVec.setResponseVector(responseVector[j]);

      mle = iVec.maximumLikelihoodEstimate(-6.0, 6.0);
      se = iVec.mleStandardErrorAt(mle);
      testStudentsDomain.setStudentName("Student "+(j+1));
      testStudentsDomain.setMLE(mle);
      testStudentsDomain.setSE(se);
      mleAndSEStudentsList.add(testStudentsDomain);
    }

    return mleAndSEStudentsList;
  }

  @Override
  public double calcEstimatedForNextItem(double[] IParam,double randomAbility,int itemResponse) {

    Irm3PL model = new Irm3PL(IParam[0], IParam[1], 0, 1.0);
    return SloppyMath.round(model.probability(randomAbility,IParam,itemResponse,1.0),3);

  }


}
