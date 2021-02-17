package com.example.androidclient;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import ClientBackend.MainControl;
import supports.Helper;
import java.util.ArrayList;

public class PersonalDetails extends AppCompatActivity {

    TextView nameShow;
    ListView watchlistShow;
    // TransferThread transferThread;

    static final MainControl control = LogOrRegister.control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details);

        nameShow = findViewById(R.id.infoName);
        watchlistShow = findViewById(R.id.listviewWatchlist);

        Intent intent = getIntent();
        Bundle infos = intent.getExtras();

        // String name = infos.getString(BundleKeys.NAME);
        String name = LogOrRegister.username;
        nameShow.setText(name);

        // ArrayList<String> watchlist = infos.getStringArrayList(BundleKeys.WATCHLIST);
        ArrayList<String> watchlist = Helper.transferToString(control.getWatchListShares());
        ListAdapter adapter = new ListAdapter(this, R.layout.activity_ls_adapter, watchlist);
        watchlistShow.setAdapter(adapter);
    }

    public void sell(View view) {
        Intent intent = new Intent(PersonalDetails.this, Sell.class);
        startActivity(intent);
    }


    public void add(View view) {
        Intent intent = new Intent(PersonalDetails.this, AddToWatchlist.class);
        startActivity(intent);

//        Message message = new Message();
//        Bundle bundle = new Bundle();
//        bundle.putString("CODE", "SZ300921");
//        message.setData(bundle);
//        message.obj = TypeInformation.WATCHLIST_EDIT;
//
//
//        transferThread.handler.sendMessage(message);
    }

    public void buy(View view) {
        Intent intent = new Intent(PersonalDetails.this, Buy.class);
        startActivity(intent);
    }
}