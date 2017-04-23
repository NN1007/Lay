package com.example.hp1.datepickerdialog;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        Date mydate=new Date();
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
            Calendar c = Calendar.getInstance(Locale.CHINA);
            year=c.get(Calendar.YEAR);
            month=c.get(Calendar.MONTH);
            day=c.get(Calendar.DAY_OF_MONTH);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String time=y+"-"+m+"-"+d;
            Date date = null;
            String Maxtime=year+"-"+month+"-"+day;
            Date Maxtime_date=null;
            try{
                date = format.parse(time);
                Maxtime_date = format.parse(Maxtime);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if(date.getTime()<= Maxtime_date.getTime())  {
                year=y;
                month=m;
                day=d;
                updateDate();
            }else{
                Toast.makeText(getApplicationContext(), "设置日期无效", Toast.LENGTH_SHORT).show();
            }

        }

        private void updateDate(){
            showdate.setText("当前日期：" + year + "-" + (month+1) + "-" +day);
        }
    };

}
