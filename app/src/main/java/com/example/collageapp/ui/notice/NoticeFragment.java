package com.example.collageapp.ui.notice;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class NoticeFragment extends Fragment {

    private RecyclerView noticerecycler;
    private ProgressBar progressBar;
    private TextView waittext;
    private ArrayList<NoticeData> list;
    private noticeadapter adapter;

    private DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_notice, container, false);

        noticerecycler = view.findViewById(R.id.noticerecycler);
        progressBar = view.findViewById(R.id.progressbar);
        waittext = view.findViewById(R.id.waittext);

        reference = FirebaseDatabase.getInstance().getReference().child("Notice");


        noticerecycler.setLayoutManager(new LinearLayoutManager(getContext()));
        noticerecycler.setHasFixedSize(true);

        getnotice();

        return view;
    }

    private void getnotice() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    NoticeData data = snapshot1.getValue(NoticeData.class);
                    list.add(0,data);
                }

                adapter = new noticeadapter(getContext(), list);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                waittext.setVisibility(View.GONE);
                noticerecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                progressBar.setVisibility(View.GONE);
                waittext.setVisibility(View.GONE);
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}