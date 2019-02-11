package com.rsi.adaptive.calc.factory;

/**
 * Created by suryadevarap on 2/6/19.
 */
public enum ConsumerEnum {

  ONLINE("online"),
  SIMULATION("simulation");

  private  String consumerName;

  ConsumerEnum( String consumerName) {
    this.consumerName = consumerName;
  }

  public String getConsumerName() {
    return consumerName;
  }
}