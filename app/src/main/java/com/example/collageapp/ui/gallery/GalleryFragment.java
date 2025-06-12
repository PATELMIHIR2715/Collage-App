package com.example.collageapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView convacation,greenery,events,farewell,sport_week,Annual_function,hackathon,college_function,republic_day,other;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        convacation = view.findViewById(R.id.convacationRecycler);
        greenery = view.findViewById(R.id.greenaryRecycler);
        events = view.findViewById(R.id.eventRecycler);
        farewell = view.findViewById(R.id.farewellRecycler);
        sport_week = view.findViewById(R.id.sportweekRecycler);
        Annual_function = view.findViewById(R.id.annualfunctionRecycler);
        hackathon = view.findViewById(R.id.hackathonRecycler);
        college_function = view.findViewById(R.id.collegefunctionRecycler);
        republic_day = view.findViewById(R.id.republicdayRecycler);
        other = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getconvoimage();
        getgreenaryimage();
        geteventsimage();
        getfarewellimage();
        getsportweekimage();
        getannualfuncimage();
        gethackathonimage();
        getcollegefuncimage();
        getrepublicdayimage();
        getotherimage();

        return view;
    }

    private void getconvoimage() {
        reference.child("Convocation").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                convacation.setLayoutManager(new GridLayoutManager(getContext(),4));
                convacation.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void getgreenaryimage() {
        reference.child("Annual Function").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(0,data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                Annual_function.setLayoutManager(new GridLayoutManager(getContext(),4));
                Annual_function.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void geteventsimage() {
        reference.child("College Function").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                college_function.setLayoutManager(new GridLayoutManager(getContext(),4));
                college_function.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getfarewellimage() {
        reference.child("Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                events.setLayoutManager(new GridLayoutManager(getContext(),4));
                events.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getsportweekimage() {
        reference.child("Farewell").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                farewell.setLayoutManager(new GridLayoutManager(getContext(),4));
                farewell.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getannualfuncimage() {
        reference.child("Greenery").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                greenery.setLayoutManager(new GridLayoutManager(getContext(),4));
                greenery.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void gethackathonimage() {
        reference.child("Hackathon").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                hackathon.setLayoutManager(new GridLayoutManager(getContext(),4));
                hackathon.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getcollegefuncimage() {
        reference.child("Republic Day").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                republic_day.setLayoutManager(new GridLayoutManager(getContext(),4));
                republic_day.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getrepublicdayimage() {
        reference.child("Other").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                other.setLayoutManager(new GridLayoutManager(getContext(),4));
                other.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void getotherimage() {
        reference.child("Sport Weeks").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String) snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                sport_week.setLayoutManager(new GridLayoutManager(getContext(),4));
                sport_week.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "DataBase Error", Toast.LENGTH_SHORT).show();
            }
        });

    }
}