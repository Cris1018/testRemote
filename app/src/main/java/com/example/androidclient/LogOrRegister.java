package com.example.androidclient;

import ClientBackend.MainControl;
import android.content.Intent;
import android.os.*;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import supports.Helper;
import supports.Share;
import supports.Status;
import supports.TypeInformation;

import java.util.ArrayList;

public class LogOrRegister extends AppCompatActivity {

    static MainControl control;
    static String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_or_register);

        new Thread(new Runnable() {
            @Override
            public void run() {
                control = new MainControl();
            }
        }).start();

    }

    public void Register(View view) {

        Intent intent = new Intent(LogOrRegister.this, Registration.class);
        startActivity(intent);
    }

    public void SignIn(View view) {

        EditText usernameInput = findViewById(R.id.usernameInput);
        EditText passwordInput = findViewById(R.id.passwordInput);
        username = usernameInput.getText().toString();
        String password = passwordInput.getText().toString();

        if (username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "shouldn'd be empty!", Toast.LENGTH_SHORT).show();
            return;
        }

        Status result = control.login(username, password);

        if (result.equals(Status.LOGIN_SUCCESSES)){
            ArrayList<Share> watchlist = control.getWatchListShares();
            ArrayList<String> watchlistToString = Helper.transferToString(watchlist);

            Intent intent = new Intent(LogOrRegister.this, PersonalDetails.class);

//            Bundle infos = new Bundle();
//            infos.putString(BundleKeys.NAME, username);
//            infos.putStringArrayList(BundleKeys.WATCHLIST, watchlistToString);
//
//            intent.putExtras(infos);
            startActivity(intent);
        }
    }
}