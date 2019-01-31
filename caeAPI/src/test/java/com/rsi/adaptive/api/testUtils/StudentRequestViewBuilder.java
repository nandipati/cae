package com.rsi.adaptive.api.testUtils;

import com.rsi.adaptive.api.view.AdaptiveActivity;
import com.rsi.adaptive.api.view.CurrentItems;
import com.rsi.adaptive.api.view.CustomStateRequest;
import com.rsi.adaptive.api.view.InterimRanges;
import com.rsi.adaptive.api.view.PreviousItems;
import com.rsi.adaptive.api.view.ScoreEstimation;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.TestLength;
import com.rsi.adaptive.api.view.ThetaRange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suryadevarap on 1/30/19.
 */
public class StudentRequestViewBuilder {

  private StudentRequestView requestView = new StudentRequestView();

  public StudentRequestView build(){
    return requestView;
  }

  public StudentRequestViewBuilder withAll(){

    return this.withSessionId("E439F6D7-15E4-4EBF-912F-EAA7CDB8171B")
                .withAdaptiveActivity(createAdaptiveActivity())
                .withCurrentItems(createCurrentItems())
                .withCustomState(createCustomState());

  }

  private AdaptiveActivity createAdaptiveActivity() {
    AdaptiveActivity adaptiveActivity = new AdaptiveActivity();
    adaptiveActivity.setActivityId("");
    adaptiveActivity.setStudentId("");
    return adaptiveActivity;
  }

  private List<CurrentItems> createCurrentItems() {
    List<CurrentItems> currentItemsList = new ArrayList<>();
    CurrentItems currentItems = new CurrentItems();
    currentItems.setReference("Item1");
    currentItems.setOrganisationId("1");
    currentItems.setItemPoolId("MATH-2018");
    currentItems.setScore(1);
    currentItems.setMaxScore(1);
    currentItems.setDiscriminator(1.183);
    currentItems.setDifficulty(0.848);
    currentItemsList.add(currentItems);
    return currentItemsList;
  }

  private CustomStateRequest createCustomState() {
    CustomStateRequest customState = new CustomStateRequest();
    ThetaRange thetaRange = new ThetaRange();
    thetaRange.setMin(-3);
    thetaRange.setMax(+3);
    TestLength testLength = new TestLength();
    testLength.setTotalItems(40);
    testLength.setTotalPassages(0);
    customState.setGrade("2");
    customState.setSubject("MATH");
    customState.setThetaRange(thetaRange);
    customState.setTotalPoolItems(100);
    customState.setD(1.7);
    customState.setIRT_model("2PL");
    customState.setItemType("item");
    customState.setTestLength(testLength);
    customState.setScoreEstimation(createScoreEstimation());
    customState.setPreviousItems(createPreviousItems());
    return customState;
  }

  private List<ScoreEstimation> createScoreEstimation() {
    List<ScoreEstimation> scoreEstimationList = new ArrayList<>();
    ScoreEstimation scoreEstimation = new ScoreEstimation();
    InterimRanges interimRanges = new InterimRanges();
    interimRanges.setFrom(5);
    interimRanges.setTo(39);
    scoreEstimation.setEstimationType("MLE");
    scoreEstimation.setTestType("item");
    scoreEstimation.setInterimRanges(interimRanges);
    scoreEstimationList.add(scoreEstimation);
    return scoreEstimationList;
  }

  private List<PreviousItems> createPreviousItems() {
    List<PreviousItems> previousItemsList = new ArrayList<>();
    PreviousItems previousItems = new PreviousItems();
    previousItems.setReference("item3");
    previousItems.setDiscriminator(1.183);
    previousItems.setDifficulty(0.848);
    previousItemsList.add(previousItems);
    return previousItemsList;
  }

  public StudentRequestViewBuilder withSessionId(String sessionId){
    requestView.setSessionId(sessionId);
    return this;
  }

  public StudentRequestViewBuilder withAdaptiveActivity(AdaptiveActivity adaptiveActivity){
    requestView.setAdaptiveActivity(adaptiveActivity);
    return this;
  }

  public StudentRequestViewBuilder withCurrentItems(List<CurrentItems> currentItems){
    requestView.setCurrentItems(currentItems);
    return this;
  }

  public StudentRequestViewBuilder withCustomState( CustomStateRequest customState){
    requestView.setCustomState(customState);
    return this;
  }

  public static StudentRequestViewBuilder studentRequestView(){
    return new StudentRequestViewBuilder().withAll();
  }

}
