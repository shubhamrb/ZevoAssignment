package com.zevo.assignment.retrofit;

import com.zevo.assignment.utils.AppConstants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {
    private static RetrofitInterface apiInterface;

    public static RetrofitInterface getApiInterface() {
        if (apiInterface == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiInterface = retrofit.create(RetrofitInterface.class);
        }
        return apiInterface;
    }
}
