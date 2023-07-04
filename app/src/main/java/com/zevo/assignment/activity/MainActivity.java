package com.zevo.assignment.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import com.zevo.assignment.adapter.NewsListAdapter;
import com.zevo.assignment.databinding.ActivityMainBinding;
import com.zevo.assignment.model.NewsModel;
import com.zevo.assignment.presenter.MainContract;
import com.zevo.assignment.presenter.MainPresenter;

import java.lang.reflect.Type;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View, NewsListAdapter.OnClickListener {
    private ActivityMainBinding binding;
    private NewsListAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presenter = new MainPresenter(this);
        setUpNewsAdapter();
    }

    private void setUpNewsAdapter() {
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        binding.recyclerNews.setLayoutManager(manager);
        adapter = new NewsListAdapter(getApplicationContext(), this);
        binding.recyclerNews.setAdapter(adapter);
        getNewsList();
    }

    private void getNewsList() {
        presenter.fetchData();
    }

    @Override
    public void onNewsClick(String url) {
        startActivity(new Intent(this, WebActivity.class).putExtra("url", url));
    }

    @Override
    public void showData(JsonObject jsonObject) {
        Type news = new TypeToken<List<NewsModel>>() {
        }.getType();
        List<NewsModel> list = new Gson().fromJson(jsonObject.get("articles").getAsJsonArray().toString(), news);
        adapter.setList(list);
    }
}