package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

/**
 * Created by suryadevarap on 1/16/19.
 */
public abstract class ItemFactory {

  private static Item getClient(String client){

    if(Consumer.SIMULATION.getConsumerName().equals(client))
      return new Simulation();
    else if (Consumer.ONLINE.getConsumerName().equals(client))
      return new Online();
    return null;
  }


  public static StudentResponseView getNextItem(String client, StudentRequestView requestView){

    Item nextItemConsumer = getClient(client);

    StudentResponseView responseView;

    if (requestView.getCurrentItems().getReference()!=null){
      responseView= nextItemConsumer != null ? nextItemConsumer.nextItem(requestView) : null;
    }else{
      responseView= nextItemConsumer != null ? nextItemConsumer.firstItem(requestView) : null;
    }

    return responseView;
  }

}
