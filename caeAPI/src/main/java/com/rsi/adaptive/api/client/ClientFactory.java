package com.rsi.adaptive.api.client;

/**
 * Created by suryadevarap on 1/16/19.
 */
public class ClientFactory {
  public static Client getClient(String client){

    if(Consumer.SIMULATION.getConsumerName().equals(client))
      return new Simulation();
    else if (Consumer.ONLINE.getConsumerName().equals(client))
      return new Learnosity();
    return null;
  }

}
