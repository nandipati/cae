package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.controller.exception.NotFoundException;
import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by suryadevarap on 1/16/19.
 */
public abstract class ItemFactory {

  private static Item getClient(String client){

    if(Consumer.SIMULATION.getConsumerName().equals(client))
      return new Simulation();
    else if (Consumer.ONLINE.getConsumerName().equals(client))
      return new Online();
    else throw new NotFoundException("please use valid consumer either 'simulation' or 'online' ");
  }

  public static StudentResponseView getNextItem(String client, StudentRequestView requestView){

    Item nextItemConsumer = getClient(client);

    StudentResponseView responseView;

      List<CurrentItems> currentItemsList =  requestView.getCurrentItems();

      if (!CollectionUtils.isEmpty(currentItemsList)) {
        responseView = nextItemConsumer != null ? nextItemConsumer.nextItem(requestView) : null;
      } else {
        responseView = nextItemConsumer != null ? nextItemConsumer.firstItem(requestView) : null;
      }


    return responseView;
  }

}
