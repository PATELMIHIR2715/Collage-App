package com.example.collageapp.ui.home;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.collageapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;
    private TextView bio_medical,IT,computer,chemical;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        bio_medical = view.findViewById(R.id.bio_medical);
        IT = view.findViewById(R.id.IT);
        computer = view.findViewById(R.id.computer);
        chemical = view.findViewById(R.id.chemical);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.DEPTHTRANSFORMATION);
        sliderLayout.setScrollTimeInSec(3);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        bio_medical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("On Working");
                builder.setCancelable(true);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = null;
                try {
                    dialog = builder.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dialog != null)
                    dialog.show();
            }
        });
        IT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("On Working");
                builder.setCancelable(true);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = null;
                try {
                    dialog = builder.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dialog != null)
                    dialog.show();
            }
        });
        computer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("On Working");
                builder.setCancelable(true);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = null;
                try {
                    dialog = builder.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dialog != null)
                    dialog.show();
            }
        });
        chemical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setMessage("On Working");
                builder.setCancelable(true);
                builder.setNegativeButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                AlertDialog dialog = null;
                try {
                    dialog = builder.create();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (dialog != null)
                    dialog.show();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0,0?q=Government Polytechnic Gandhinagar");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i = 0; i < 5; i++) {

            DefaultSliderView sliderView = new DefaultSliderView(getContext());

            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_main.jpg?alt=media&token=f15d34b0-b987-4a42-b3fe-fd79594e8763");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_it.jpeg?alt=media&token=2f9165f5-ea15-4612-b711-fde8db5d93bb");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_chemical2.jpeg?alt=media&token=c37bf119-ed8b-4a0a-bcdb-22566d734b17");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_republic.jpeg?alt=media&token=b7d15331-884a-46ac-817a-1d5f6e7f3bf0");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/my-college-app-d9b1b.appspot.com/o/gpg_ground.jpg?alt=media&token=9ba9e996-4ccf-449c-a2a7-644824433280");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);

            sliderLayout.addSliderView(sliderView);
        }
    }
}