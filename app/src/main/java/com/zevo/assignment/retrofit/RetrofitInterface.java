package com.zevo.assignment.retrofit;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitInterface {

    @GET("top-headlines?country=us&apiKey=73aa0fe4cd7f4632bc918fc22093b824")
    Call<JsonObject> getNewsList();
}
