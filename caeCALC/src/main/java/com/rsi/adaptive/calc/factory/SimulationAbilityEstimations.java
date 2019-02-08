package com.rsi.adaptive.calc.factory;

import com.itemanalysis.psychometrics.optimization.SloppyMath;
import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.CustomStateRequestDomain;
import com.rsi.adaptive.calc.domain.EstimationsDomain;
import com.rsi.adaptive.calc.domain.ScoreEstimationDomain;
import com.rsi.adaptive.calc.enums.EstimatedMethod;
import com.rsi.adaptive.calc.service.MLEAndSECalcService;
import com.rsi.adaptive.calc.service.MLEAndSECalcServiceImpl;
import com.rsi.adaptive.calc.util.Grade;
import com.rsi.adaptive.calc.view.MLEAndSE;
import org.apache.commons.lang3.ArrayUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Service
public class SimulationAbilityEstimations implements AbilityEstimations {

  private MLEAndSECalcServiceImpl calcService = new MLEAndSECalcServiceImpl();

  @Override
  public EstimationsDomain getEstimations(List<CurrentItemsDomain> currentItemsList,
      CustomStateRequestDomain customStateRequestDomain) {

    EstimatedMethod estimatedMethod = null;

    Optional<ScoreEstimationDomain> scoreEstimations = customStateRequestDomain.getScoreEstimation().stream().findFirst();

    if(scoreEstimations.isPresent()){
      ScoreEstimationDomain estimationDomain = scoreEstimations.get();
      estimatedMethod  =  estimationDomain.getEstimationMethod();
    }

    EstimationsDomain estimationsDomain = new EstimationsDomain();
    Grade g =  Grade.getGradeAbility(customStateRequestDomain.getGrade());
    double ability = g.getAbility();

    int correct = 1;
    int in_correct =0;

    List<Integer> myResponseList = new ArrayList<>();
    double[] disc ;
    double[] diff ;


    List<Double> listOfDisc = new ArrayList<>();
    List<Double> listOfDiff = new ArrayList<>();


    if (!CollectionUtils.isEmpty(currentItemsList)) {

      if(currentItemsList.size() >=5){
        // after 5th item
        currentItemsList.stream().forEach(currentItems ->{
          myResponseList.add(currentItems.getScore());
          listOfDisc.add(currentItems.getDiscriminator());
          listOfDiff.add(currentItems.getDifficulty());
        });

        disc = ArrayUtils.toPrimitive(listOfDisc.toArray(new Double[listOfDisc.size()]));
        diff= ArrayUtils.toPrimitive(listOfDiff.toArray(new Double[listOfDiff.size()]));

        long correctCount = myResponseList.stream().filter(response -> response.equals(correct)).count();
        long inCorrectCount = myResponseList.stream().filter(response -> response.equals(in_correct)).count();

        if(correctCount == currentItemsList.size() ) {
          ability = ability+(0.1);
          estimationsDomain.setEstimatedAbility(ability);
        }if(inCorrectCount == currentItemsList.size() ){
          ability = ability-(0.1);
          estimationsDomain.setEstimatedAbility(ability);
        }else if (EstimatedMethod.MLE.equals(estimatedMethod)) {
          MLEAndSE mleAndSE = calcService
              .getMLEAndSE(buildResponseVectorPerStudent(currentItemsList), currentItemsList.size(), disc, diff,
                  customStateRequestDomain.getThetaRange().getMin(), customStateRequestDomain.getThetaRange().getMax());

          estimationsDomain.setEstimatedAbility(SloppyMath.round(mleAndSE.getMle(), 3));
          estimationsDomain.setMle(SloppyMath.round(mleAndSE.getMle(), 3));
          estimationsDomain.setSe(SloppyMath.round(mleAndSE.getSe(), 3));
        }
      }else{
        //first 4 items
        estimationsDomain.setEstimatedAbility(ability);
      }
    }else{
      //firstItem
      estimationsDomain.setEstimatedAbility(ability);
    }
    return estimationsDomain;
  }

  private byte[][] buildResponseVectorPerStudent(List<CurrentItemsDomain> currentItemsList){

    byte[][] responseVector ;
    int numberOfExamine =1;
    int numberOfItems = currentItemsList.size();
    responseVector = new byte[numberOfExamine][numberOfItems];
    int row=0;
    int j=0;
    for (CurrentItemsDomain currentItems: currentItemsList){
      responseVector[row][j] = Byte.parseByte(String.valueOf(currentItems.getScore()));
      j++;
    }
    return responseVector;

  }

}
