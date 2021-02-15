package com.hoho.android.usbserial.examples;

import android.os.Bundle;
import android.os.Handler;
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

public class CaramelRisimo extends Fragment {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private Gif gif;
    private String value = "63,0,0";
    private boolean click = true;
    int count = ((MainActivity)getActivity()).database[28];
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.caramelrisimo_fragment, container, false);
        caramelRisimoHandler(rootView);
        return rootView;
    }

    private void caramelRisimoHandler(ViewGroup rootView) {

        ImageView teaSelect = (ImageView)rootView.findViewById(R.id.teaSelect28);
        ImageView back = (ImageView)rootView.findViewById(R.id.img_back);
        ImageView home = (ImageView)rootView.findViewById(R.id.img_home);

        fragmentManager = getActivity().getSupportFragmentManager();
        transaction = fragmentManager.beginTransaction();
        if(count==0)teaSelect.setImageResource(R.drawable.soldout);
        teaSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!click){
                ((Video)getActivity()).videoRestart();
                ((Video)getActivity()).videoStart("63,0,0");
                if (count > 0) {
                    count = count - 1;
                    teaSelect.setImageResource(R.drawable.afterteaselect);
                    imageChange(back,home);
                    handler();
                }else {
                    Toast.makeText(getContext(), "품절된 메뉴를 선택하셨습니다", Toast.LENGTH_SHORT).show();
                }
                }
                else {
                    ((Video) getActivity()).videoRestart();
                    ((Video) getActivity()).videoStart("63,0,0");
                    click = false;
                    Toast.makeText(getActivity().getApplicationContext(), "한번더 눌러주세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void handler(){
        Handler hand = new Handler();
        hand.postDelayed(new Runnable() {
            @Override
            public void run() {
                gif = new Gif();
                Bundle bundle = new Bundle();
                bundle.putString(value,"value");
                gif.setArguments(bundle);
                transaction.replace(R.id.gif,gif).commitAllowingStateLoss();
            }
        },1000);
    }
    private void imageChange(ImageView back, ImageView home) {
        home.setImageResource(R.drawable.selecthome);
        back.setImageResource(R.drawable.selectback);

    }
}
