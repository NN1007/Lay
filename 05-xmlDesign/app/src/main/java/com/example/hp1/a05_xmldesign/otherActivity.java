package com.example.hp1.a05_xmldesign;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by hp1 on 2017/3/27.
 */

public class otherActivity extends AppCompatActivity {
    private Intent intent;
    private Bundle bunde;
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other);

        Bundle bunde = this.getIntent().getExtras();
        String ans = bunde.getString("ans");

        String setText = "";
        if (ans.equals("in")){
            setText="正确";
        }else{
            setText="错误";
        }
        TextView tv1 = (TextView) findViewById(R.id.text1);
        tv1.setText("您选择的答案是："+setText);

        Button btn3_back = (Button) findViewById(R.id.button_back);
        btn3_back.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v){
                otherActivity.this.setResult(RESULT_OK,intent);
                otherActivity.this.finish();
            }
        });
    }
}
