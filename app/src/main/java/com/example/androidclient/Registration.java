package com.example.androidclient;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.ArrayList;
import supports.Status;
import supports.TypeInformation;

public class Registration extends AppCompatActivity {

    static boolean SUCCESS = false;

    EditText setName;
    EditText setPassword;
    EditText setBalance;
    Button confirm;
    TransferThread transferThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        transferThread = new TransferThread();
        new Thread(transferThread).start();

        setName = findViewById(R.id.setName);
        setPassword = findViewById(R.id.setPassword);
        setBalance = findViewById(R.id.setBalance);
        confirm = findViewById(R.id.buttonConfirm);
    }

    public void confirmRegister(View view) {

        if (!setName.getText().toString().isEmpty() && !setPassword.getText().toString().isEmpty() &&
                !setBalance.getText().toString().isEmpty()){

            Message message = new Message();

            message.obj = TypeInformation.REGISTRATION;
            Bundle bundle = new Bundle();
            bundle.putString(BundleKeys.NAME, setName.getText().toString());
            bundle.putString(BundleKeys.PASSWORD, setPassword.getText().toString());
            bundle.putDouble(BundleKeys.BALANCE, Double.parseDouble(setBalance.getText().toString()));
            message.setData(bundle);

            transferThread.handler.sendMessage(message);

            while (!Registration.SUCCESS){
                System.out.println("waiting to be confirmed....");
            }

            Intent intent = new Intent(Registration.this, PersonalDetails.class);
            Bundle infos = new Bundle();

            // initialize the watchlist
            ArrayList<String> emptyWatchlist = new ArrayList<>();

            infos.putString(BundleKeys.NAME, setName.getText().toString());
            infos.putStringArrayList(BundleKeys.WATCHLIST, emptyWatchlist);
            intent.putExtras(infos);

            // reset
            Registration.SUCCESS = false;

            startActivity(intent);
        }
    }
}