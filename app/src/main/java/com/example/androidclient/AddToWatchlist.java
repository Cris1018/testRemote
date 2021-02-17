package com.example.androidclient;

import ClientBackend.MainControl;
import supports.*;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;

public class AddToWatchlist extends AppCompatActivity {

    static final MainControl control = LogOrRegister.control;
    EditText shareName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_watchlist);

        shareName = findViewById(R.id.addWatchlistInput);
    }

    public void search(View view) {
        String nameOrCode = shareName.getText().toString();

        if (nameOrCode.length()>0){
            ArrayList<Share> result = control.getFuzzySearch(nameOrCode);

            if (result.size() > 0){
                Toast.makeText(this, "already get the result!", Toast.LENGTH_SHORT).show();
                ArrayList<String> resultStrings = Helper.transferToString(result);

                Bundle bundle = new Bundle();
                bundle.putStringArrayList(BundleKeys.SEARCHRES, resultStrings);

                Intent intent = new Intent(AddToWatchlist.this, SearchShareAdd.class);
                intent.putExtras(bundle);
                startActivity(intent);
            } else {
                Toast.makeText(this, "cannot find result...please try again", Toast.LENGTH_SHORT).show();
            }
        }
    }
}