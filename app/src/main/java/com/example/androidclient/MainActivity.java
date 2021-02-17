package com.example.androidclient;

import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RotateAnimation rotate = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(8000);
        rotate.setRepeatCount(Animation.INFINITE);

        final TextView text = findViewById(R.id.textView0);
        final ImageView img = findViewById(R.id.imageView0);
        img.startAnimation(rotate);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LogOrRegister.class);
                startActivity(intent);
                img.setAnimation(null);
                MainActivity.this.finish();
            }
        };

        timer.schedule(task, 5000);
        text.animate().alpha(0).setDuration(5000);
    }
}