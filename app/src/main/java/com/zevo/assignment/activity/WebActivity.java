package com.zevo.assignment.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.zevo.assignment.databinding.ActivityWebBinding;

public class WebActivity extends AppCompatActivity {
    private String url;
    private ActivityWebBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityWebBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        url = getIntent().getStringExtra("url");

        binding.webView.loadUrl(url);
    }
}