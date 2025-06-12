package com.example.collageapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.collageapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel> list;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_baseline_laptop,"Information Technology","The department will strive to develop technically proficient and ethically sound diploma IT engineers to serve the industry and society."));
        list.add(new BranchModel(R.drawable.ic_baseline_computer,"Computer","To develop technically skilled, adaptive, ethical technicians as well as prospective technologists for the industry and the society."));
        list.add(new BranchModel(R.drawable.beaker,"Chemical","To develop technically skilled, adaptive, ethical technicians as well as prospective technologists for the industry and the society."));

        adapter = new BranchAdapter(getContext(),list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.aboutcollege_image);

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_ground.jpg?alt=media&token=9ba9e996-4ccf-449c-a2a7-644824433280")
                .into(imageView);

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Government Polytechnic Gandhinagar");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}