package com.example.collageapp.ui.faculty;

import static android.app.ProgressDialog.show;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.collageapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FacultyFragment extends Fragment {

    private RecyclerView IT,BM,CS,chemical;
    private LinearLayout itnodata,bmnodata,csnodata,chemicalnodata;
    private List<FacultyData> list1,list2,list3,list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference,dbref;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_faculty, container, false);


        IT = view.findViewById(R.id.itdepartment);
        BM = view.findViewById(R.id.bmdepartment);
        CS = view.findViewById(R.id.cedepartment);
        chemical = view.findViewById(R.id.chemicaldepartment);

        itnodata = view.findViewById(R.id.itnodata);
        bmnodata = view.findViewById(R.id.bmnodata);
        csnodata = view.findViewById(R.id.cenodata);
        chemicalnodata = view.findViewById(R.id.chemicalnodata);

        reference = FirebaseDatabase.getInstance().getReference().child("facultys");

        IT();
        CS();
        BM();
        Chemical();

        return view;
    }

    private void IT() {
        dbref = reference.child("Imformation Techanolodgy");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list1 = new ArrayList<>();
                if (!snapshot.exists()){
                    itnodata.setVisibility(View.VISIBLE);
                    IT.setVisibility(View.GONE);
                }else {

                    itnodata.setVisibility(View.GONE);
                    IT.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        FacultyData data = dataSnapshot.getValue(FacultyData.class);
                        list1.add(data);
                    }
                    IT.setHasFixedSize(true);
                    IT.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list1, getContext());
                    IT.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void CS() {
        dbref = reference.child("Computer Engineering");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list2 = new ArrayList<>();
                if (!snapshot.exists()){
                    csnodata.setVisibility(View.VISIBLE);
                    CS.setVisibility(View.GONE);
                }else {

                    csnodata.setVisibility(View.GONE);
                    CS.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        FacultyData data = dataSnapshot.getValue(FacultyData.class);
                        list2.add(data);
                    }
                    CS.setHasFixedSize(true);
                    CS.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list2, getContext());
                    CS.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void Chemical() {
        dbref = reference.child("Chemical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list3 = new ArrayList<>();
                if (!snapshot.exists()){
                    chemicalnodata.setVisibility(View.VISIBLE);
                    chemical.setVisibility(View.GONE);
                }else {

                    chemicalnodata.setVisibility(View.GONE);
                    chemical.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        FacultyData data = dataSnapshot.getValue(FacultyData.class);
                        list3.add(data);
                    }
                    chemical.setHasFixedSize(true);
                    chemical.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list3, getContext());
                    chemical.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void BM() {
        dbref = reference.child("Bio Madical");
        dbref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list4 = new ArrayList<>();
                if (!snapshot.exists()){
                    bmnodata.setVisibility(View.VISIBLE);
                    BM.setVisibility(View.GONE);
                }else {

                    bmnodata.setVisibility(View.GONE);
                    BM.setVisibility(View.VISIBLE);
                    for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                        FacultyData data = dataSnapshot.getValue(FacultyData.class);
                        list4.add(data);
                    }
                    BM.setHasFixedSize(true);
                    BM.setLayoutManager(new LinearLayoutManager(getContext()));
                    adapter = new TeacherAdapter(list4, getContext());
                    BM.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}