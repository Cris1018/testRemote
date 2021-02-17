package com.example.androidclient;

import android.os.Looper;

public class TransferThread implements Runnable{
    MessageHandler handler;
    @Override
    public void run() {
        Looper.prepare();
        handler = new MessageHandler();
        Looper.loop();
    }
}
