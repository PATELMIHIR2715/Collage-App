package com.example.collageapp.ui.faculty;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.collageapp.R;

import java.util.List;

public class TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewAdapter> {

    private List<FacultyData> list;
    private Context context;

    public TeacherAdapter(List<FacultyData> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.faculty_item_layout, parent, false);

        return new TeacherViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeacherViewAdapter holder, int position) {

        FacultyData item = list.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());
        try {
            Glide.with(context).load(item.getImage()).placeholder(R.drawable.avatar).into((ImageView) holder.image);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TeacherViewAdapter extends RecyclerView.ViewHolder {

        private TextView name, email, post;
        private ImageView image;

        public TeacherViewAdapter(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teachername);
            email = itemView.findViewById(R.id.teacheremail);
            post = itemView.findViewById(R.id.teacherpost);
            image = itemView.findViewById(R.id.teacherimage);

        }

    }
}
