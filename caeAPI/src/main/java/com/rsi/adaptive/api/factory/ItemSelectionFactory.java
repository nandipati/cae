package com.rsi.adaptive.api.factory;

import com.rsi.adaptive.calc.factory.ConsumerEnum;

/**
 * Created by suryadevarap on 2/6/19.
 */
public abstract class ItemSelectionFactory {

  public static ItemSelection getClient(String client){

    if(ConsumerEnum.SIMULATION.getConsumerName().equals(client))
      return new SimulationItemSelection();
    else if (ConsumerEnum.ONLINE.getConsumerName().equals(client))
      return new OnlineItemSelection();
    return null;
  }
}
