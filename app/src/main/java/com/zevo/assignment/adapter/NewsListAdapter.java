package com.zevo.assignment.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.zevo.assignment.R;
import com.zevo.assignment.model.NewsModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.MyViewHolder> {
    private Context context;
    private List<NewsModel> list;
    private OnClickListener listener;

    public NewsListAdapter(Context context, OnClickListener listener) {
        this.context = context;
        this.listener = listener;
        list = new ArrayList<>();
    }

    @NonNull
    @Override
    public NewsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.news_layout, null);
        return new MyViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        if (list.size() > 0) {
            NewsModel model = list.get(position);
            holder.txt_name.setText(model.getSource().getName());
            holder.txt_title.setText(model.getTitle());
            holder.txt_name.setText(model.getDescription());
            Glide.with(context).load(model.getUrlToImage()).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.image_news);

            holder.itemView.setOnClickListener(v -> {
                listener.onNewsClick(model.getUrl());
            });
        }
    }

    public interface OnClickListener {
        void onNewsClick(String url);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<NewsModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView txt_name, txt_title, txt_des;
        private ImageView image_news;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_title = itemView.findViewById(R.id.txt_title);
            txt_des = itemView.findViewById(R.id.txt_des);
            image_news = itemView.findViewById(R.id.image_news);
        }
    }
}
