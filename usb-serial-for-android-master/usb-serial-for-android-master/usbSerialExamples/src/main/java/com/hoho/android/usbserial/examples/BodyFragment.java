package com.hoho.android.usbserial.examples;

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

public class BodyFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Blending1 blending1;
    private Blending2 blending2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.body_fragment, container, false);
        bodyImgHandler(rootView);
        return rootView;
    }

    private void bodyImgHandler(ViewGroup rootView) {
        ImageView yesCaffeine = (ImageView)rootView.findViewById(R.id.heavyBody);
        ImageView noCaffeine = (ImageView)rootView.findViewById(R.id.lightBody);
        ImageView back = (ImageView)rootView.findViewById(R.id.img_back3);
        ImageView home = (ImageView)rootView.findViewById(R.id.img_home3);
        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        yesCaffeine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blending1 = new Blending1();
                transaction.add(R.id.blending1,blending1).commit();
            }
        });
        noCaffeine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                blending2 = new Blending2();
                transaction.add(R.id.blending2,blending2).commit();
            }
        });

    }
}
