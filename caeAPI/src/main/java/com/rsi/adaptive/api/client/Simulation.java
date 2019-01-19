package com.rsi.adaptive.api.client;

import com.itemanalysis.psychometrics.optimization.SloppyMath;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;
import com.rsi.adaptive.calc.math.CALCUtils;
import com.rsi.adaptive.calc.service.MLEAndSECalcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * Created by suryadevarap on 1/15/19.
 */
@Component
public class Simulation implements Item {

  @Autowired
  private MLEAndSECalcService mleAndSECalcService;

  private static MLEAndSECalcService service;

  @Autowired
  private void  setMleAndSECalcService(MLEAndSECalcService mleAndSECalcService){
    service = mleAndSECalcService;

  }

  @Override
  public StudentResponseView firstItem(StudentRequestView requestView) {

    NextItem nextItem = new NextItem();
    StudentResponseView responseView = new StudentResponseView();

    double randomAbility = randomGradeGenerator(requestView.getGrade());
    double randomDisc = randomDiscGenerator();
    double randomDiff = randomDiffGenerator(randomAbility);

    nextItem.setItemPoolId("firstPoolId");
    nextItem.setReference("First-Item");
    nextItem.setOrganisationId(1);
    nextItem.setDiscriminator(randomDisc);
    nextItem.setDifficulty(randomDiff);

    responseView.setNextItem(nextItem);
    responseView.setLastItem(false);

    return responseView;
  }

  @Override
  public StudentResponseView nextItem(StudentRequestView requestView) {
    StudentResponseView responseView = new StudentResponseView();

    double disc = requestView.getCurrentItems().getDiscriminator();
    double diff = requestView.getCurrentItems().getDifficulty();

    double randomAbility = randomGradeGenerator(requestView.getGrade());

    double[] IParam = {disc, diff};
    double estimatedTheta = service.calcEstimatedForNextItem(IParam,randomAbility,requestView
        .getCurrentItems().getItemResponse());

    responseView.setNextItem(getNextItem(estimatedTheta));
    return responseView;
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

  private NextItem getNextItem(double estimatedTheta) {
    NextItem nextItem = new NextItem();
    Random random = new Random();
    int i = random.nextInt(10);
    String itemNumber="item-"+i;

    nextItem.setItemPoolId("someItemPoolId");
    nextItem.setReference(itemNumber);
    nextItem.setDiscriminator(randomDiscGenerator());
    nextItem.setDifficulty(randomDiffGenerator(estimatedTheta));

    return nextItem;

  }

}
