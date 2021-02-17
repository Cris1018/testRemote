package com.example.androidclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.textclassifier.ConversationAction;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import supports.StockShare;

public class SpinnerAdapter extends ArrayAdapter<StockShare> {

    public SpinnerAdapter(Context context, ArrayList<StockShare> shares){
        super(context,  0, shares);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        return initView(position, convertView, parent);
    }

    public View getDropDownView(int position, View convertView, ViewGroup parent){
        return initView(position, convertView, parent);
    }

    private View initView(int position, View convertView, ViewGroup parent){
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_ls_adapter, parent, false);
        }

        StockShare shareString = getItem(position);

        TextView name = convertView.findViewById(R.id.shareNameAdapter);
        TextView code = convertView.findViewById(R.id.shareCodeAdapter);
        TextView price = convertView.findViewById(R.id.sharePriceAdapter);
        TextView percentage = convertView.findViewById(R.id.sharePercentageAdapter);

        if (shareString != null){
            name.setText(shareString.getStock_name());
            code.setText(shareString.getStock_code());
            price.setText(String.valueOf(shareString.getMargin_profit()));
            percentage.setText(String.valueOf(shareString.getProfit_rate()));
        }
        return convertView;
    }

}
