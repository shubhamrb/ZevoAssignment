package com.zevo.assignment.presenter;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zevo.assignment.model.NewsModel;
import com.zevo.assignment.retrofit.RetrofitInterface;
import com.zevo.assignment.retrofit.RetrofitManager;

import java.lang.reflect.Type;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class MainPresenter implements MainContract.Presenter {
    private final MainContract.View view;

    public MainPresenter(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void fetchData() {
        RetrofitInterface apiInterface = RetrofitManager.getApiInterface();
        Call<JsonObject> call1 = apiInterface.getNewsList();
        call1.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, retrofit2.Response<JsonObject> response) {
                JsonObject jsonObject = response.body();
                Log.e("Response", jsonObject.toString());
                view.showData(jsonObject);
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                call.cancel();
            }
        });

    }
}


