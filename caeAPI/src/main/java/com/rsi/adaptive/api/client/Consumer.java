package com.rsi.adaptive.api.client;

/**
 * Created by suryadevarap on 1/15/19.
 */
public enum Consumer {

  ONLINE("online"),
  SIMULATION("simulation");

  private  String consumerName;

  Consumer( String consumerName) {
    this.consumerName = consumerName;
  }

  public String getConsumerName() {
    return consumerName;
  }
}
