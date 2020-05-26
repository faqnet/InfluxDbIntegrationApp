package com.example.services;

import com.example.metrics.MetricDataWrapper;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface InfluxLambdaService {

    @POST("/mobile")
    Call<ResponseBody> uploadMetric(@Body MetricDataWrapper metrics);
}
