package com.rsi.adaptive.api.controller.wrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.rsi.adaptive.api.view.InputResponse;
import com.rsi.adaptive.api.view.ItemResponses;
import com.rsi.adaptive.api.view.TestStudents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * Created by suryadevarap on 12/21/18.
 */
public class InputFileWrapper {


  private static byte[][] responseVector = null;

  private InputResponse inputResponse = new InputResponse();
  private List<TestStudents> testStudentsList = new ArrayList<>();

  private ItemResponses itemResponses = new ItemResponses();;
  private List<ItemResponses> itemResponsesList = new ArrayList<>();
  private TestStudents testStudents;



  public InputResponse readTextFile(){
    responseVector = new byte[20][40];
    try{
      File f = FileUtils.toFile(this.getClass().getResource("/testData/mixed-format.txt"));
      BufferedReader br = new BufferedReader(new FileReader(f));

      String line = "";
      String[] s = null;
      int row = 0;
      while((line=br.readLine())!=null){

        s = line.split(",");
        for(int j=0;j<s.length;j++){
          testStudents = new TestStudents();
          String name = "Student "+(row+1);

          responseVector[row][j] = Byte.parseByte(s[j]);

          itemResponses.setItemNumber(j+1);
          itemResponses.setItemResponse(responseVector[row][j]);


          testStudents.setStudentName(name);

          itemResponsesList.add(itemResponses);
          itemResponses = new ItemResponses();

        }
        row++;

        testStudents.setItemResponsesList(itemResponsesList);
        itemResponsesList = new ArrayList<>();
        testStudentsList.add(testStudents);


      }
      br.close();
    }catch(IOException ex){
      ex.printStackTrace();
    }

    inputResponse.setStudents(testStudentsList);
    return inputResponse;


  }


  public byte[][] buildResponseVector(InputResponse response){

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    String json = gson.toJson(response);

    System.out.println(json);

    int itemResponse;
    responseVector = new byte[20][40];
    int row=0;
    testStudentsList = response.getStudents();

    for (TestStudents students: testStudentsList){
      int j=0;
      itemResponsesList =  students.getItemResponsesList();

      for(ItemResponses items : itemResponsesList){

        itemResponse = items.getItemResponse();
        responseVector[row][j] = Byte.parseByte(String.valueOf(itemResponse));
        j++;
      }
      row++;
  }
    return responseVector;

  }

}
