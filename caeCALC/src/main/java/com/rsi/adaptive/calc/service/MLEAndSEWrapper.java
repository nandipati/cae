package com.rsi.adaptive.calc.service;

import com.itemanalysis.psychometrics.data.VariableName;
import com.itemanalysis.psychometrics.irt.estimation.IrtExaminee;
import com.itemanalysis.psychometrics.irt.model.Irm3PL;
import com.itemanalysis.psychometrics.irt.model.ItemResponseModel;
import com.rsi.adaptive.calc.enums.ItemParameters;

/**
 * Created by suryadevarap on 1/7/19.
 */
public class MLEAndSEWrapper {

  public void calculationForAll(){

    int numberOfItems = ItemParameters.DISCRIMINATOR.getParam().length;
    ItemParameters disc = ItemParameters.DISCRIMINATOR;
    ItemParameters diff = ItemParameters.DIFFICULTY;

    ItemResponseModel[] irmArray = new ItemResponseModel[numberOfItems];

    VariableName iName;
    for(int i=0;i<numberOfItems;i++){
      String name = "V"+i;
      iName = new VariableName(name);

      irmArray[i] = new Irm3PL(disc.getParam()[i], diff.getParam()[i],  1.7);
      irmArray[i].setName(iName);
    }


    IrtExaminee iVec = new IrtExaminee(irmArray);


  }

}
