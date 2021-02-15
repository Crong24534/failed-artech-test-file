package com.hoho.android.usbserial.examples;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Blending1 extends Fragment {

    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Flavor1 flavor1;
    private Scent1 scent1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.blending1_fragment, container, false);
        blending1ImageHandler(rootView);
        return rootView;
    }

    private void blending1ImageHandler(ViewGroup rootView) {
        ImageView yesBlend = (ImageView)rootView.findViewById(R.id.yesBlend);
        ImageView noBlend = (ImageView)rootView.findViewById(R.id.noBlend);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();


        yesBlend.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("CommitTransaction")
            @Override
            public void onClick(View v) {
                flavor1 = new Flavor1();
                transaction.add(R.id.flavor1, flavor1).commit();
            }
        });
        noBlend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scent1 = new Scent1();
                transaction.add(R.id.scent1,scent1).commit();
            }
        });
    }
}
