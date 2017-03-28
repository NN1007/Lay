package com.example.hp1.a05_xmldesign;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton r1 = null;
    RadioButton r2 = null;
    RadioButton r3 = null;
    RadioButton r4 = null;
    RadioGroup radioGroup = null;
    RadioButton currentRadioButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        r1 = (RadioButton) findViewById(R.id.a);
        r2 = (RadioButton) findViewById(R.id.b);
        r3 = (RadioButton) findViewById(R.id.c);
        r4 = (RadioButton) findViewById(R.id.d);
        r1.setClickable(true);

        Button btn1_sure = (Button)findViewById(R.id.sure);
        Button btn2_cancel = (Button)findViewById(R.id.cancel);
        btn1_sure.setOnClickListener(new btn1_sure());
        btn2_cancel.setOnClickListener(new btn2_cancel());

    }
    class btn1_sure implements View.OnClickListener {
        @Override
        public void onClick(View v){
            String ans="";
            if(r1.isChecked()){
                ans="on";
            }else if(r2.isChecked()){
                ans="at";
            }else if(r3.isChecked()){
                ans="of";
            }else if(r4.isChecked()){
                ans="in";
            }
            Intent intent = new Intent();
            intent.setClass(MainActivity.this,otherActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("ans",ans);
            intent.putExtras(bundle);
            startActivityForResult(intent,0);
        }

    }
    class btn2_cancel implements View.OnClickListener{
        @Override
        public void onClick(View v){
            radioGroup.clearCheck();
            setTitle(" ");

        }
    }
}
