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

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by suryadevarap on 1/7/19.
 */
@Service
public class MLEAndSECalcServiceImpl implements MLEAndSECalcService {

  private NextItemDomain nextItem = new NextItemDomain();

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
  public NextItemDomain calcMLESimulationForFirstItem(int grade){

    double randomAbility = randomGradeGenerator(grade);
    double randomDisc = randomDiscGenerator();
    double randomDiff = randomDiffGenerator(randomAbility);

    nextItem.setItemPoolId("firstPoolId");
    nextItem.setReference("First-Item");
    nextItem.setOrganisationId(1);
    nextItem.setDiscriminator(randomDisc);
    nextItem.setDifficulty(randomDiff);

    return nextItem;

  }

  @Override
  public NextItemDomain calcMLESimulationForNextItem(CurrentItemsDomain currentItemsDomain, int grade) {

    double disc = currentItemsDomain.getDiscriminator();
    double diff = currentItemsDomain.getDifficulty();
    double randomAbility = randomGradeGenerator(grade);

    Irm3PL model = new Irm3PL(disc, diff, 0, 1.0);
    double[] IParam = {disc, diff};
    double estimatedTheta= SloppyMath.round(model.probability(randomAbility,IParam,currentItemsDomain.itemResponse,1.0),3);
    nextItem = getNextItem(estimatedTheta);

    return nextItem;
  }

  private NextItemDomain getNextItem(double estimatedTheta) {

    Random random = new Random();
    int i = random.nextInt(10);
    String itemNumber="item-"+i;

    nextItem.setItemPoolId("someItemPoolId");
    nextItem.setReference(itemNumber);
    nextItem.setDiscriminator(randomDiscGenerator());
    nextItem.setDifficulty(randomDiffGenerator(estimatedTheta));

    return nextItem;

  }

  private double randomGradeGenerator(int grade) {
    double randomNumber = 0.0;
    if(grade == 3)  {
      randomNumber = CALCUtils.randomDouble(-1.2,-0.5);
    }
    if(grade == 4)  {
      randomNumber = CALCUtils.randomDouble(-1.3,-1.0);
    }
    return SloppyMath.round(randomNumber, 3);
  }

  private double randomDiscGenerator() {
    double disc = CALCUtils.randomDouble(0.5,2.0);
    return SloppyMath.round(disc, 3)  ;
  }

  private double randomDiffGenerator(double randomAbility) {
    double diff = SloppyMath.round(CALCUtils.randomDouble(-0.25,0.25),3);
    return (SloppyMath.round(randomAbility+diff,3));
  }

}
