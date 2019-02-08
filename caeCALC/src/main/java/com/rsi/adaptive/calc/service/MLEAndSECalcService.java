package com.rsi.adaptive.calc.service;

import com.rsi.adaptive.calc.domain.TestStudentsDomain;
import com.rsi.adaptive.calc.view.MLEAndSE;

import java.util.List;

/**
 * Created by suryadevarap on 1/7/19.
 */
public interface MLEAndSECalcService {

   List<TestStudentsDomain> calculateMLEAndSEForAll(byte[][] responseVector);

   double calcEstimatedForNextItem(double[] IPram,double randomAbility,int itemResponse);

    MLEAndSE getMLEAndSE(byte[][] responseVector,int numberOfItems,double[] disc, double[] diff,
       double thetaMin,double thetaMax);

}
