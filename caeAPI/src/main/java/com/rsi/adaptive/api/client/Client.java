package com.rsi.adaptive.api.client;

import com.rsi.adaptive.api.service.MLEAndSEService;
import com.rsi.adaptive.api.view.StudentRequestView;
import com.rsi.adaptive.api.view.StudentResponseView;

/**
 * Created by suryadevarap on 1/15/19.
 */
public interface Client {

   StudentResponseView clientCall(StudentRequestView requestView,MLEAndSEService mleAndSEService);
}
