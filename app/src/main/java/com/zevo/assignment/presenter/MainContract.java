package com.zevo.assignment.presenter;

import com.google.gson.JsonObject;

public interface MainContract {
    interface View {
        void showData(JsonObject data);
    }

    interface Presenter {
        void fetchData();
    }
}