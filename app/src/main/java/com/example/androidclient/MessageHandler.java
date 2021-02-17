package com.example.androidclient;

import ClientBackend.MainControl;
import android.os.Handler;
import android.os.Message;
import androidx.annotation.NonNull;
import supports.Status;
import supports.TypeInformation;

public class MessageHandler extends Handler {

    static final MainControl mainControl= LogOrRegister.control;

    @Override
    public void handleMessage(@NonNull Message msg) {

        TypeInformation type = (TypeInformation) msg.obj;
        Status result;

        switch (type){
            case WATCHLIST_EDIT:
                result = mainControl.addWatchlist(msg.getData().getString(BundleKeys.CODE));

                if (result.equals(Status.WatchlistOperation_SUCCESSES)){
                }
                break;

            case REGISTRATION:
                result = mainControl.registration(msg.getData().getString(BundleKeys.NAME), msg.getData().getString(BundleKeys.PASSWORD)
                , msg.getData().getDouble(BundleKeys.BALANCE));

                if (result.equals(Status.REGISTRATION_SUCCESSES)){
                    System.out.println("successful registration!!!");
                    // modify the class variable
                    Registration.SUCCESS = true;
                }
                break;
        }
    }
}
