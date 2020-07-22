package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private AndroidFragment androidFragment;
    private JavaFragment javaFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        fragmentManager = getSupportFragmentManager();

        androidFragment = new AndroidFragment();
        javaFragment = new JavaFragment();

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container,androidFragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.button_android) void setAndroid(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,androidFragment);
        fragmentTransaction.commit();
    }

    @OnClick(R.id.button_java) void setJava(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,javaFragment);
        fragmentTransaction.commit();
    }
}