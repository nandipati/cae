package com.rsi.adaptive.api.controller;

import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.testUtils.AuthenticateAs;
import com.rsi.adaptive.api.testUtils.AuthenticationRule;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

import static com.rsi.adaptive.api.testUtils.StudentRequestViewBuilder.studentRequestView;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by suryadevarap on 1/30/19.
 */
public class CAEControllerTest extends RestControllerTest {

  @Autowired
  private MLEAndSEService mleAndSEService;

  @Rule
  public AuthenticationRule authenticationRule = new AuthenticationRule();

  @Test
  @AuthenticateAs(AuthenticateAs.AuthType.TRUSTED_API)
  public void showNextItem()throws Exception {

    String consumer = "simulation";

    StudentRequestView requestView = studentRequestView().build();

    when(mleAndSEService.getNextItem(any(),any())).thenReturn(new
        StudentResponseView());

    mockMvc.perform(post("/v1/cae/nextItem?consumer={consumer}", consumer)
        .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON).
            content(objectMapper.writeValueAsString(requestView)))
        .andDo(print())
        .andExpect(status().isOk());


  }

}
