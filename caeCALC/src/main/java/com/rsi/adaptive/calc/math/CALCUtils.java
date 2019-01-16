package com.rsi.adaptive.calc.math;

import java.util.Random;

/**
 * Created by suryadevarap on 1/15/19.
 */
public final class CALCUtils {

    private CALCUtils(){}

   public static double randomDouble(double rangeMin, double rangeMax){
     Random random= new Random();
    return  rangeMin + (rangeMax - rangeMin) * random.nextDouble();
   }
}
