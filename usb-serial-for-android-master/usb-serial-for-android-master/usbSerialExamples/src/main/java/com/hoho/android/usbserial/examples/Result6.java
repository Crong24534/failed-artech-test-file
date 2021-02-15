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

public class Result6 extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private PeachOolong peachOolongFragment;
    private RichOolong richOolongFragment;
    private String value6 = "25,20,0";
    private String peach = "60,0,0";
    private String rich = "55,0,0";
    private boolean click = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.result6_fragment, container, false);
        result6ImageHandler(rootView);
        return rootView;
}

    private void result6ImageHandler(ViewGroup rootView) {
        ImageView peachOolong = (ImageView)rootView.findViewById(R.id.peachOolong);
        ImageView richOolong = (ImageView)rootView.findViewById(R.id.richOolong);
        ImageView back = (ImageView)rootView.findViewById(R.id.img_back10);
        ImageView home = (ImageView)rootView.findViewById(R.id.img_home10);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();

        peachOolong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!true) {
                    ((Video) getActivity()).videoRestart();
                    ((Video) getActivity()).videoStart("60,0,0");
                    peachOolong.setImageResource(R.drawable.afterselect);
                    imageChange(back, home);
                    Handler hand = new Handler();
                    hand.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            peachOolongFragment = new PeachOolong();
                            transaction.add(R.id.teaPeachOolong, peachOolongFragment).commitAllowingStateLoss();
                        }
                    }, 1000);
                }

                ((Video) getActivity()).videoRestart();
                ((Video) getActivity()).videoStart("60,0,0");
                click = false;

            }
        });
        richOolong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Video)getActivity()).videoRestart();
                ((Video)getActivity()).videoStart("55,0,0");
                richOolong.setImageResource(R.drawable.afterselect);
                imageChange(back,home);
                Handler hand = new Handler();
                hand.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        richOolongFragment = new RichOolong();
                        transaction.add(R.id.teaRichOolong,richOolongFragment).commitAllowingStateLoss();
                    }
                },1000);
            }
        });
    }

    private void imageChange(ImageView back, ImageView home) {
        home.setImageResource(R.drawable.selecthome);
        back.setImageResource(R.drawable.selectback);

    }

}
