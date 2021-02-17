package com.example.androidclient;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<String> {

    Context context;
    int resource;

    public ListAdapter(@NonNull Context context, int resource, ArrayList<String> array) {
        super(context, resource, array);
        this.context = context;
        this.resource = resource;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        String shareString = getItem(position);

        LayoutInflater inflater = LayoutInflater.from(context);
        convertView = inflater.inflate(resource, parent, false);

        TextView name = convertView.findViewById(R.id.shareNameAdapter);
        TextView code = convertView.findViewById(R.id.shareCodeAdapter);
        TextView price = convertView.findViewById(R.id.sharePriceAdapter);
        TextView percentage = convertView.findViewById(R.id.sharePercentageAdapter);

        name.setText(shareString.split(" ")[0]);
        code.setText(shareString.split(" ")[1]);
        price.setText(shareString.split(" ")[2]);
        percentage.setText(shareString.split(" ")[3]);

        return convertView;
    }
}
