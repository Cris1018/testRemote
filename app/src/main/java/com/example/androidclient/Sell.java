package com.example.androidclient;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.ArrayList;
import ClientBackend.MainControl;
import supports.StockShare;

public class Sell extends AppCompatActivity {

    static final MainControl control = LogOrRegister.control;

    Spinner chooseShare;
    EditText price;
    EditText amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell);

        chooseShare = findViewById(R.id.spinner);
        price = findViewById(R.id.sellPrice);
        amount = findViewById(R.id.sellAmt);

        ArrayList<StockShare> holdings = control.getStocks();
        SpinnerAdapter adapter = new SpinnerAdapter(this, holdings);
        chooseShare.setAdapter(adapter);
    }

    public void sell(View view) {


    }
}