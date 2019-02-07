package com.rsi.adaptive.calc.service;

import com.itemanalysis.psychometrics.data.VariableName;
import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
import com.itemanalysis.psychometrics.irt.model.Irm3PL;
import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
import com.itemanalysis.psychometrics.optimization.SloppyMath;

import com.rsi.adaptive.calc.domain.TestStudentsDomain;
import com.rsi.adaptive.calc.enums.ItemParameters;
import com.rsi.adaptive.calc.view.MLEAndSE;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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

  @Override
  public MLEAndSE getMLEAndSE(byte[][] responseVector,int numberOfItems,double[] disc, double[] diff,
      double thetaMin,double thetaMax) {

    MLEAndSE mleAndSE = new MLEAndSE();

    ItemResponseModel[] irmArray = new ItemResponseModel[numberOfItems];

    VariableName iName;
    for(int i=0;i<numberOfItems;i++){
      String name = "V"+i;
      iName = new VariableName(name);

      irmArray[i] = new Irm3PL(disc[i], diff[i],  1.7);
      irmArray[i].setName(iName);
    }


    IrtExaminee  iVec = new IrtExaminee(irmArray);

    for (byte[] aResponseVector : responseVector) {
      double mle;
      double se;

      iVec.setResponseVector(aResponseVector);

      mle = iVec.maximumLikelihoodEstimate(thetaMin, thetaMax);
      se = iVec.mleStandardErrorAt(mle);

      mleAndSE.setMle(mle);
      mleAndSE.setSe(se);
    }



    return mleAndSE;
  }

}
