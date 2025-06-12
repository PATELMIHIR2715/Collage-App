package com.example.collageapp.ui.notice;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.collageapp.FullImageView;
import com.example.collageapp.R;

import java.util.ArrayList;

public class noticeadapter extends RecyclerView.Adapter<noticeadapter.noticeviewadapter> {

    private Context context;
    private ArrayList<NoticeData> list;

    public noticeadapter(Context context, ArrayList<NoticeData> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public noticeviewadapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news_feed_layout, parent, false);
        return new noticeviewadapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull noticeviewadapter holder, @SuppressLint("RecyclerView") int position) {

        NoticeData currentitem = list.get(position);

        holder.noticetitle.setText(currentitem.getTitle());
        holder.date.setText(currentitem.getDate());
        holder.time.setText(currentitem.getTime());

        try {
            if (currentitem.getImage() != null)
                Glide.with(context).load(currentitem.getImage()).into(holder.noticeimage);
        } catch (Exception e) {
            e.printStackTrace();
        }
        holder.noticeimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FullImageView.class);
                intent.putExtra("image", currentitem.getImage());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class noticeviewadapter extends RecyclerView.ViewHolder {

        private TextView noticetitle, date, time;
        private ImageView noticeimage;

        public noticeviewadapter(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
            noticetitle = itemView.findViewById(R.id.noticetitle);
            noticeimage = itemView.findViewById(R.id.noticeimage);

        }
    }
}
