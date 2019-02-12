package com.rsi.adaptive.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by suryadevarap on 12/19/18.
 */

@SpringBootApplication
@ComponentScan(value = {"com.rsi","com.itemanalysis"})
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class})

public class CAEApplication {

  public static void main(String[] args){
    SpringApplication.run(CAEApplication.class,args);
  }

  @RequestMapping("/")
  String home() {
    return "CAE Running!!";
  }


}
