package com.example.hp1.actionbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.ViewConfiguration;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            ViewConfiguration mconfig = ViewConfiguration.get(this);
            Field menuKeyField;
            menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(null != menuKeyField){
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(mconfig, false);
            }
        }catch (NoSuchFieldException e){
            e.printStackTrace();
        }catch (IllegalAccessException e){
            e.printStackTrace();
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.action_calendar:
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
                Date curDate = new Date(System.currentTimeMillis());
                String str = formatter.format(curDate);
                Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_call:
                Intent intent = new Intent(Intent.ACTION_CALL,
                        Uri.parse("tel:10086"));
                startActivity(intent);
                break;
            case R.id.action_msm:
                SmsManager smsManager = SmsManager.getDefault();
                smsManager.sendTextMessage("10086",null,"10086",null,null);
        }
        return super.onOptionsItemSelected(item);

    }
}
