package com.example.hp.a02_weight;

/**
 * Created by hp on 2017/3/7.
 */
import android.os.Bundle;
import android.app.Activity;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Result extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        Bundle bunde = this.getIntent().getExtras();
        String sex = bunde.getString("sex");
        double height = bunde.getDouble("height");
        String sexText="";
        if(sex.equals("M")){
            sexText="男性";
        }else{
            sexText="女性";
        }

        String weight=this.getWeight(sex, height);


        TextView tv1=(TextView) findViewById(R.id.text1);
        tv1.setText("你是一位"+sexText+"\n你的身高是"+height+ "公分\n你的标准体重是"+weight+"公斤");
    }


    private String format(double num)
    {
        NumberFormat formatter = new DecimalFormat("0.00");
        String s=formatter.format(num);
        return s;
    }

    private String getWeight(String sex,double height)
    {
        String weight="";
        if(sex.equals("M"))
        {
            weight=format((height-80)*0.7);
        }else
        {
            weight=format((height-70)*0.6);
        }
        return weight;
    }
}

