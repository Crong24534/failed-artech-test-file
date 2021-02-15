package com.hoho.android.usbserial.examples;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Result1 extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Flavor1 flavor1;
    private StrawberryCream strawberryCreamFragment;
    private ForestFruits forestFruitsFragment;
    private CaramelRisimo caramelRisimoFragment;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.result1_fragment, container, false);
        result1ImgHandler(rootView);
        return rootView;
    }

    private void result1ImgHandler(ViewGroup rootView) {
        ImageView strawberryCream = (ImageView) rootView.findViewById(R.id.strawberryCream);
        ImageView forestFruits = (ImageView) rootView.findViewById(R.id.forestFruits);
        ImageView caramelRisimo = (ImageView) rootView.findViewById(R.id.caramelRisimo);
        ImageView back = (ImageView) rootView.findViewById(R.id.img_back8);
        ImageView home = (ImageView) rootView.findViewById(R.id.img_home8);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        strawberryCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strawberryCream.setImageResource(R.drawable.afterselect);
                imageChange(back, home);
                Handler hand = new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        strawberryCreamFragment = new StrawberryCream();
                        transaction.add(R.id.teaStrawberryCream, strawberryCreamFragment, "strawberryCream").commit();
                    }
                }, 1000);
            }
        });
        forestFruits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                forestFruits.setImageResource(R.drawable.afterselect);
                imageChange(back, home);
                Handler hand = new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        forestFruitsFragment = new ForestFruits();
                        transaction.add(R.id.teaForestFruits, forestFruitsFragment).commit();
                    }
                }, 1000);
            }
        });
        caramelRisimo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                caramelRisimo.setImageResource(R.drawable.afterselect);
                imageChange(back, home);
                Handler hand = new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        caramelRisimoFragment = new CaramelRisimo();
                        transaction.add(R.id.teaCaramelRisimo, caramelRisimoFragment).commit();
                    }
                }, 1000);

            }
        });
    }

    private void imageChange (ImageView back, ImageView home){
        home.setImageResource(R.drawable.selecthome);
        back.setImageResource(R.drawable.selectback);

    }
}