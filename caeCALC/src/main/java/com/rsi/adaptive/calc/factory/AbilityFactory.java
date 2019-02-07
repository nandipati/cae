package com.rsi.adaptive.calc.factory;

/**
 * Created by suryadevarap on 2/6/19.
 */
public abstract class AbilityFactory {

  public static AbilityEstimations getClient(String client){

    if(ConsumerEnum.SIMULATION.getConsumerName().equals(client))
      return new SimulationAbilityEstimations();
    else if (ConsumerEnum.ONLINE.getConsumerName().equals(client))
      return new OnlineAbilityEstimations();
    return null;
  }
}
