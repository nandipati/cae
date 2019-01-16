package com.rsi.adaptive.calc.service;

import com.rsi.adaptive.calc.domain.CurrentItemsDomain;
import com.rsi.adaptive.calc.domain.NextItemDomain;
import com.rsi.adaptive.calc.domain.TestStudentsDomain;

import java.util.List;

/**
 * Created by suryadevarap on 1/7/19.
 */
public interface MLEAndSECalcService {

   List<TestStudentsDomain> calculateMLEAndSEForAll(byte[][] responseVector);

   NextItemDomain calcMLESimulationForFirstItem(int grade);

   NextItemDomain calcMLESimulationForNextItem(CurrentItemsDomain currentItemsDomain,int grade);

}
