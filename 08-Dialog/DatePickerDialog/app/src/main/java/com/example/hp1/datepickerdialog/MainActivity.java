package com.example.hp1.datepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextView showdate;
    private Button setdate;
    private int year;
    private int month;
    private int day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showdate = (TextView) this.findViewById(R.id.showtime);
        setdate = (Button) this.findViewById(R.id.setdate);

        Calendar c = Calendar.getInstance(Locale.CHINA);
        Date mydate = new Date();
        c.setTime(mydate);
        showdate.setText("当前日期："+year+"-"+(month+1)+"-"+day);
        setdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog my_datePickerDialog = new DatePickerDialog(MainActivity.this,DateListener,year,month,day);
                my_datePickerDialog.show();
            }
        });
    }
    private DatePickerDialog.OnDateSetListener DateListener= new DatePickerDialog.OnDateSetListener(){

        @Override
        public void onDateSet(DatePicker v, int y, int m, int d) {
            year=y;
            month=m;
            day=d;
            updateDate();
        }

        private void updateDate(){
            showdate.setText("当前日期：" + year + "-" + (month+1) + "-" +day);
        }
    };

}
