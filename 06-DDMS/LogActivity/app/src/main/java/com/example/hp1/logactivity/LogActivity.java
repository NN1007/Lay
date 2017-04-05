package com.example.hp1.logactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by hp1 on 2017/3/30.
 */

public class LogActivity extends AppCompatActivity {
    private static final String LIFT_TAG = "LogActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onPause");
        super.onPause();
    }

    @Override
    protected void onRestart() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onRestart");
        super.onRestart();
    }

    @Override
    protected void onResume() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onResume");
        super.onResume();
    }

    @Override
    protected void onStart() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onStart");
        super.onStart();
    }

    @Override
    protected void onStop() {
        Log.v(MainActivity.LIFT_TAG, "SecondActivity ---> onStop");
        super.onStop();
    }
}
