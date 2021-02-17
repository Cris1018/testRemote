package com.example.androidclient;

import android.os.Looper;

public class TransferThread2 extends Thread {
    MessageHandler handler;

    @Override
    public void run() {
        Looper.prepare();
        handler = new MessageHandler();
        Looper.loop();
    }
}
