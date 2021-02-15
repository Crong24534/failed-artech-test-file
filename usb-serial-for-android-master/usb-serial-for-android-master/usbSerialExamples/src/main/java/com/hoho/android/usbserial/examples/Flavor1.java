package com.hoho.android.usbserial.examples;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Flavor1 extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Blending1 blending1;
    private Result1 result1;
    private Result2 result2;
    private boolean click = true;
    private String value1 = "15,31,28";
    private String value2 = "19,13,0";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.flavor1_fragment, container, false);
        heavyFlavorImgHandler(rootView);
        return rootView;
    }

    private void heavyFlavorImgHandler(ViewGroup rootView) {
        ImageView sweet = (ImageView) rootView.findViewById(R.id.sweet);
        ImageView sour = (ImageView) rootView.findViewById(R.id.sour);
        ImageView back = (ImageView) rootView.findViewById(R.id.img_back7);
        ImageView home = (ImageView) rootView.findViewById(R.id.img_home7);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        sweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(click==false) {
                    turnPage(1);
                }
                else {
                    ((Video) getActivity()).videoRestart();
                    ((Video) getActivity()).videoStart("15,31,28");
                    Toast.makeText(getActivity().getApplicationContext(), "한번더 눌러주세요", Toast.LENGTH_SHORT).show();
                    click = false;
                }

            }
        });
        sour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!click){
                    ((Video)getActivity()).videoRestart();
                    ((Video)getActivity()).videoStart("19,13,0");
                    ((Video)getActivity()).videoPause();
                turnPage(2);
                }else {
                ((Video)getActivity()).videoRestart();
                ((Video)getActivity()).videoStart("19,13,0");
                click=false;
                Toast.makeText(getActivity().getApplicationContext(),"한번더 눌러주세요",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private void turnPage(int i) {
        if(i==1){
            result1 = new Result1();
            transaction.add(R.id.result1, result1, "result1").commit();
        }
        else{
            result2 = new Result2();
            transaction.add(R.id.result2 ,result2, "result2").commit();
        }
    }
}
