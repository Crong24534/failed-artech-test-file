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

public class HomeFragment extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private CaffeineFragment caffeineFragment;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.home_fragment, container, false);
        homeImageHandler(rootView);
        return rootView;
    }

    private void homeImageHandler(ViewGroup rootView) {
        ImageView recommend = (ImageView)rootView.findViewById(R.id.recommend);
        ImageView back = (ImageView)rootView.findViewById(R.id.img_back1);
        ImageView home = (ImageView)rootView.findViewById(R.id.img_home);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        recommend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caffeineFragment = new CaffeineFragment();
                transaction.add(R.id.caffeine,caffeineFragment).commit();
            }
        });
    }

}
