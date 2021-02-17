package com.example.androidclient;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import ClientBackend.MainControl;
import supports.Status;

public class SearchShareAdd extends AppCompatActivity {

    ListView searchRes;
    static final MainControl control = LogOrRegister.control;
    Status result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_share_add);

        searchRes = findViewById(R.id.listviewSearchRes);
        final Message message = new Message();
        final Bundle bundle = new Bundle();
        Intent intent = getIntent();
        Bundle info = intent.getExtras();

        ArrayList<String> stringRes = info.getStringArrayList(BundleKeys.SEARCHRES);
        ListAdapter adapter = new ListAdapter(this, R.layout.activity_ls_adapter, stringRes);

        searchRes.setAdapter(adapter);
        searchRes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String toAdd = (String) parent.getItemAtPosition(position);
                System.out.println(toAdd);
                String codeAdd = toAdd.split(" ")[0];
                result = control.addWatchlist(codeAdd);

//                transferThread = new TransferThread();
//                new Thread(transferThread).start();

//                message.obj = TypeInformation.WATCHLIST_EDIT;
//                bundle.putString(BundleKeys.CODE, toAdd);
//                message.setData(bundle);

//                if (transferThread != null && message != null && transferThread.handler!=null){
//                    MessageHandler myHandler = new MessageHandler();
//                    myHandler.sendMessage(message);
//                } else {
//                    System.out.println("error!!!!!");
//                    System.out.println(transferThread == null);
//                    System.out.println(transferThread.handler == null); // this is the problem
//                }
            }
        });

        while (result == null){

        }

        if (result.equals(Status.WatchlistOperation_SUCCESSES)){
            Toast.makeText(this, "successfully add!!", Toast.LENGTH_SHORT).show();
        } else if (result.equals(Status.WatchlistOperation_FAILED)){
            Toast.makeText(this, "share already exists", Toast.LENGTH_SHORT).show();
        }

    }

    public void back(View view) {
        Intent intent = new Intent(SearchShareAdd.this, PersonalDetails.class);
        startActivity(intent);
    }
}