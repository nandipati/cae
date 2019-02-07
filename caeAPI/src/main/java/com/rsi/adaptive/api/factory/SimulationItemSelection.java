package com.rsi.adaptive.api.factory;

import com.itemanalysis.psychometrics.optimization.SloppyMath;
import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.NextItem;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.calc.util.CALCUtils;

import java.util.List;


/**
 * Created by suryadevarap on 2/6/19.
 */
public class SimulationItemSelection implements ItemSelection {

  @Override
  public NextItem getNextItem(double estimatedAbility,StudentRequestView requestView) {

    NextItem nextItem = new NextItem();
    List<CurrentItems> currentItemsList =  requestView.getCurrentItems();

    int i = currentItemsList.size();
    String itemNumber="Item"+(i+1);

    nextItem.setDifficulty(randomDiffGenerator(estimatedAbility));
    nextItem.setReference(itemNumber);
    nextItem.setItemPoolId("MATH-2018");
    nextItem.setOrganisationId(1);
    nextItem.setDiscriminator(randomDiscGenerator());

    return nextItem;
  }

  private double randomDiffGenerator(double estimatedAbility) {
  double diff = SloppyMath.round(CALCUtils.randomDouble(-0.25,0.25),3);
  return (SloppyMath.round(estimatedAbility+diff,3));
}

  private double randomDiscGenerator() {
    double disc = CALCUtils.randomDouble(0.5,2.0);
    return SloppyMath.round(disc, 3);
  }
}
