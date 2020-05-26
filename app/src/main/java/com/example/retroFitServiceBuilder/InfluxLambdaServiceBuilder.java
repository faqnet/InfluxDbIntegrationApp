package com.example.retroFitServiceBuilder;

import com.example.services.InfluxLambdaService;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InfluxLambdaServiceBuilder {

    private static Retrofit retrofit;
    private static final String BASE_URL = "base url";

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;

    }
}
