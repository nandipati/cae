package com.rsi.adaptive.api.factory;

import com.rsi.adaptive.calc.factory.ConsumerEnum;

import org.springframework.stereotype.Component;

/**
 * Created by suryadevarap on 2/6/19.
 */
@Component
public class ItemSelectionFactory {

  public static ItemSelection getClient(String client){

    if(ConsumerEnum.SIMULATION.getConsumerName().equals(client))
      return new SimulationItemSelection();
    else if (ConsumerEnum.ONLINE.getConsumerName().equals(client))
      return new OnlineItemSelection();
    return null;
  }
}
