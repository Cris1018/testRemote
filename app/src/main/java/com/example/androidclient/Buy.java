package com.example.androidclient;

import ClientBackend.MainControl;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Buy extends AppCompatActivity {

    static final MainControl control = LogOrRegister.control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);


    }
}