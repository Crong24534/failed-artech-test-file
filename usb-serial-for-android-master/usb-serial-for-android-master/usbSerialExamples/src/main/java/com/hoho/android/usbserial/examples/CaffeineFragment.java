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

public class CaffeineFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;
    private BodyFragment bodyFragment;
    private EfficacyFragment efficacyFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.caffeine_fragment, container, false);
        caffeineImageHandler(rootView);
        return rootView;
    }

    private void caffeineImageHandler(ViewGroup rootView) {
        ImageView yesCaffeine = (ImageView)rootView.findViewById(R.id.yesCaffeine);
        ImageView noCaffeine = (ImageView)rootView.findViewById(R.id.noCaffeine);
        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        yesCaffeine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bodyFragment = new BodyFragment();
                transaction.add(R.id.body,bodyFragment).commit();
            }
        });
        noCaffeine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                efficacyFragment = new EfficacyFragment();
                transaction.add(R.id.efficacy,efficacyFragment).commit();
            }
        });
    }
}
