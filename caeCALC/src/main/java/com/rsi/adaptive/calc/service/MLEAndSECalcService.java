package com.rsi.adaptive.calc.service;

import com.rsi.adaptive.calc.domain.MLEAndSEStudentsDomain;

import java.util.List;

/**
 * Created by suryadevarap on 1/7/19.
 */
public interface MLEAndSECalcService {

   List<MLEAndSEStudentsDomain> calculateMLEAndSEForAll(byte[][] responseVector);
}
