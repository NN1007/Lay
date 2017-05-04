package com.example.hp1.handlermessageprogress;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar bar = null;
    Button startButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bar = (ProgressBar)findViewById(R.id.bar);
        startButton = (Button)findViewById(R.id.startButton);
        startButton.setOnClickListener(new ButtonListener());
    }
    class ButtonListener implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            bar.setVisibility(View.VISIBLE);
            updateBarHandler.post(updateThread);
        }
    }
    Handler updateBarHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            bar.setProgress(msg.arg1);
            updateBarHandler.post(updateThread);
        }
    };
    Runnable updateThread = new Runnable(){
        int i = 0 ;
        @Override
        public void run() {
            System.out.println("Begin Thread");
            i = i + 10 ;
            Message msg = updateBarHandler.obtainMessage();
            msg.arg1 = i ;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            updateBarHandler.sendMessage(msg);
            if( i == 100){
                updateBarHandler.removeCallbacks(updateThread);
            }
        }
    };
}
