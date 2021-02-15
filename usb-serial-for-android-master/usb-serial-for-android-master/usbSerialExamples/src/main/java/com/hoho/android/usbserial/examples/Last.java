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

public class Last extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.last_fragment, container, false);
        lastHandler(rootView);
        return rootView;
    }

    private void lastHandler(ViewGroup rootView) {
        ImageView goHome = (ImageView)rootView.findViewById(R.id.goHome);
        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                transaction.remove(Last.this).commitAllowingStateLoss();
                fragmentManager.popBackStack();
            }
        });
    }
}
