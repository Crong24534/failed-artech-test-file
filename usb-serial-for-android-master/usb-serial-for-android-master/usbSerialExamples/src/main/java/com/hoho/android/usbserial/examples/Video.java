package com.hoho.android.usbserial.examples;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Video extends AppCompatActivity {
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;
    private HomeFragment homeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        VideoView vv = (VideoView)findViewById(R.id.vv);
        FrameLayout frame = (FrameLayout)findViewById(R.id.home);

        Uri uri = Uri.parse("android.resource://com.hoho.android.usbserial.examples/" + R.raw.teaforyou);
        vv.setVideoURI(uri);
        vv.start();
        vv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager = getSupportFragmentManager();
                transaction = fragmentManager.beginTransaction();
                homeFragment = new HomeFragment();
                transaction.add(R.id.home,homeFragment).commit();
            }
        });
        vv.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                vv.setVideoURI(uri);
                vv.start();
            }
        });
    }
    public void videoRestart(){
        ((MainActivity)MainActivity.mContext).restart();
    }
    public void videoStart(String str){
        ((MainActivity)MainActivity.mContext).sendData(str);
    }
    public void videoPause(){
        ((MainActivity)MainActivity.mContext).disconnect();
    }

}