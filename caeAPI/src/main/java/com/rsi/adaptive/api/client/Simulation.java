package com.rsi.adaptive.api.client;

import com.itemanalysis.psychometrics.optimization.SloppyMath;
import com.rsi.adaptive.api.utils.Grade;
import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.CustomStateResponse;
import com.rsi.adaptive.api.view.EstimatedAbility;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;
import com.rsi.adaptive.calc.math.CALCUtils;
import com.rsi.adaptive.calc.service.MLEAndSECalcService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Random;

/**
 * Created by suryadevarap on 1/15/19.
 */
@Component
public class Simulation implements Item {

  private static MLEAndSECalcService service;

  @Autowired
  private void  setMleAndSECalcService(MLEAndSECalcService mleAndSECalcService){
    service = mleAndSECalcService;
  }

  @Override
  public StudentResponseView firstItem(StudentRequestView requestView) {

    NextItem nextItem = new NextItem();
    StudentResponseView responseView = new StudentResponseView();
    CustomStateResponse customStateResponse = new CustomStateResponse();
    EstimatedAbility estimatedAbility = new EstimatedAbility();

    Grade g =  Grade.getGradeAbility(requestView.getCustomState().getGrade());
    double ability = g.getAbility();

    double randomDisc = randomDiscGenerator();
    double randomDiff = randomDiffGenerator(ability);

    nextItem.setReference("Item1");
    nextItem.setItemPoolId("MATH-2018");
    nextItem.setOrganisationId(1);
    nextItem.setDiscriminator(randomDisc);
    nextItem.setDifficulty(randomDiff);

    responseView.setNextItem(nextItem);
    responseView.setLastItem(false);
    estimatedAbility.setReference(nextItem.getReference());
    customStateResponse.setEstimatedAbility(estimatedAbility);
    responseView.setCustomStateResponse(customStateResponse);

    return responseView;
  }

  @Override
  public StudentResponseView nextItem(StudentRequestView requestView) {
    StudentResponseView responseView = new StudentResponseView();
    CurrentItems latestItem = new CurrentItems();
    CustomStateResponse customStateResponse = new CustomStateResponse();
    EstimatedAbility estimatedAbility = new EstimatedAbility();

    if (!CollectionUtils.isEmpty(requestView.getCurrentItems())) {
       latestItem = requestView.getCurrentItems().get(requestView.getCurrentItems().size()-1);
    }

    double disc = latestItem.getDiscriminator();
    double diff = latestItem.getDifficulty();

    Grade g =  Grade.getGradeAbility(requestView.getCustomState().getGrade());
    double ability = g.getAbility();

    double[] IParam = {disc, diff};
    double estimatedTheta = service.calcEstimatedForNextItem(IParam,ability,latestItem.getScore());

    responseView.setNextItem(getNextItem(estimatedTheta));

    estimatedAbility.setReference(latestItem.getReference());

    customStateResponse.setEstimatedAbility(estimatedAbility);
    responseView.setCustomStateResponse(customStateResponse);
    return responseView;
  }



  private double randomDiscGenerator() {
    double disc = CALCUtils.randomDouble(0.5,2.0);
    return SloppyMath.round(disc, 3)  ;
  }

  private double randomDiffGenerator(double estimatedAbility) {
    double diff = SloppyMath.round(CALCUtils.randomDouble(-0.25,0.25),3);
    return (SloppyMath.round(estimatedAbility+diff,3));
  }

  private NextItem getNextItem(double estimatedTheta) {
    NextItem nextItem = new NextItem();
    Random random = new Random();
    int i = random.nextInt(10);
    String itemNumber="Item"+i;

    nextItem.setItemPoolId("MATH-2018");
    nextItem.setOrganisationId(1);
    nextItem.setReference(itemNumber);
    nextItem.setDiscriminator(randomDiscGenerator());
    nextItem.setDifficulty(randomDiffGenerator(estimatedTheta));

    return nextItem;
  }

}
