package com.hoho.android.usbserial.examples;

import android.annotation.SuppressLint;
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

public class Blending2 extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private BodyFragment bodyFragment;
    private Result6 result6;
    private Flavor2 flavor2;
    private String value6 = "25,20,0";
    private boolean click = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.blending2_fragment, container, false);
        blending2mageHandler(rootView);
        return rootView;
    }

    private void blending2mageHandler(ViewGroup rootView) {
        ImageView yesBlend = (ImageView)rootView.findViewById(R.id.lightYesBlend);
        ImageView noBlend = (ImageView)rootView.findViewById(R.id.lightNoBlend);
        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        yesBlend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitTransaction")
            @Override
            public void onClick(View v) {
                if(!click) {
                    ((Video) getActivity()).videoRestart();
                    ((Video) getActivity()).videoStart("25,20,0");
                    result6 = new Result6();
                    transaction.add(R.id.result6, result6).commitAllowingStateLoss();
                }else {
                    ((Video) getActivity()).videoRestart();
                    ((Video) getActivity()).videoStart("25,20,0");
                    click = false;
                    Toast.makeText(getActivity().getApplicationContext(), "한번더 눌러주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
        noBlend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flavor2 = new Flavor2();
                transaction.add(R.id.flavor2,flavor2).commitAllowingStateLoss();
            }
        });
    }
}
