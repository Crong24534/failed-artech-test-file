package com.hoho.android.usbserial.examples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import java.util.Arrays;
import java.util.Stack;

public class MainActivity extends AppCompatActivity implements FragmentManager.OnBackStackChangedListener {
    public static Context mContext;
    public static Stack<Fragment> fragmentStack = new Stack<Fragment>();
    public int database[] = new int[35];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = this;
        Arrays.fill(database,10);
        getSupportFragmentManager().addOnBackStackChangedListener(this);
        if (savedInstanceState == null)
            getSupportFragmentManager().beginTransaction().add(R.id.device, new DevicesFragment(), "devices").commit();
        else
            onBackStackChanged();
    }

    @Override
    public void onBackStackChanged() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(getSupportFragmentManager().getBackStackEntryCount()>0);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if(intent.getAction().equals("android.hardware.usb.action.USB_DEVICE_ATTACHED")) {
            TerminalFragment terminal = (TerminalFragment)getSupportFragmentManager().findFragmentByTag("terminal");
            if (terminal != null)
                terminal.status("USB device detected");
        }
        super.onNewIntent(intent);
    }

    public void restart() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TerminalFragment terminalFragment = (TerminalFragment) fragmentManager.findFragmentById(R.id.terminal);
        terminalFragment.onResume();
        terminalFragment.connect();
    }

    public void sendData(String str) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        TerminalFragment terminalFragment = (TerminalFragment) fragmentManager.findFragmentById(R.id.terminal);
        terminalFragment.send(str);
    }
    public void disconnect(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        TerminalFragment terminalFragment = (TerminalFragment) fragmentManager.findFragmentById(R.id.terminal);
        terminalFragment.onPause();
        terminalFragment.onPause();

    }
}
