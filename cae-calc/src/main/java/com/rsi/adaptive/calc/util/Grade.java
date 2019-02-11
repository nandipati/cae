package com.rsi.adaptive.calc.util;

import com.rsi.adaptive.calc.exception.NotFoundException;

import java.util.Arrays;

/**
 * Created by suryadevarap on 1/28/19.
 */
public enum Grade {


  K("K",-3.0),
  ONE("1",-2.0),
  TWO("2",-1.0),
  THREE("3",0.0),
  FOUR("4",1.0),
  FIVE("5",1.9),
  SIX("6",2.8);

  private final String grade;
  private final double ability;

  Grade(String grade, double ability) {
    this.grade=grade;
    this.ability=ability;
  }

  public String getGrade() {
    return grade;
  }

  public double getAbility() {
    return ability;
  }

  public static Grade getGradeAbility(String grade){

    return Arrays.stream(Grade.values()).filter(getGrade -> getGrade.grade.equals(grade)).findFirst()
        .orElseThrow(() -> new NotFoundException("not a Supported grade "));
  }


}
