



package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;

public class WakeUpTimeInterval extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener{
    TextView SleepTime,WakeUpTime;
    int sleepHour,sleepminutes;
    int wakeHour,wakeMinutes;
    TimePickerDialog timePickerDialog;
    Spinner spinner;
    SQLiteDatabaseHandler databaseHandler;
    Button button;
    int DrinkInterval;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        databaseHandler=new SQLiteDatabaseHandler(this);
        setContentView(R.layout.activity_wake_up_time_interval);
        SleepTime=findViewById(R.id.SleepTimeId);
        WakeUpTime=findViewById(R.id.WakeTimeId);
        spinner=findViewById(R.id.DrinkinInterval);
        final GlobalClass globalClass=(GlobalClass)getApplicationContext();


        ArrayAdapter<String> myAdaptor=new ArrayAdapter<String>(WakeUpTimeInterval.this,
                android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.drinkInterval));
        myAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdaptor);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                GlobalClass globalClass=(GlobalClass)getApplicationContext();

                switch (i){
                    case 0:
                        DrinkInterval=15;
                        break;
                    case 1:
                        DrinkInterval=30;
                        break;
                    case 2:
                        DrinkInterval=45;
                        break;
                    case 3:
                        DrinkInterval=1;
                        break;
                    case 4:
                        DrinkInterval=2;
                        break;
                    case 5:
                        DrinkInterval=3;
                        break;



                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        SleepTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment wakeUpTimeInterval=new TimePickerDialogSleepTime();
                wakeUpTimeInterval.show(getSupportFragmentManager(),"Wake Up time");


            }
        });
        WakeUpTime.setOnClickListener(new View.OnClickListener() {
                Calendar calendar=Calendar.getInstance();
                int hour=calendar.get(Calendar.HOUR);
                int minutes=calendar.get(Calendar.MINUTE);

            @Override
            public void onClick(View view) {

                timePickerDialog=new TimePickerDialog(WakeUpTimeInterval.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int Hour, int Min) {
                        WakeUpTime.setText(Hour+":"+Min);
                        GlobalClass globalClass=(GlobalClass)getApplicationContext();
                            wakeHour=Hour;
                            wakeMinutes=minutes;

                    }
                },hour,minutes,false);
timePickerDialog.show();

            }
        });
        button=findViewById(R.id.NextButton2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                globalClass.setDrinkInterval(DrinkInterval);
                globalClass.setWakeupHour(wakeHour);
                globalClass.setWakeupMin(wakeMinutes);
                globalClass.setSleepHour(sleepHour);
                globalClass.setSleepMinute(sleepminutes);
                Intent intent=new Intent(WakeUpTimeInterval.this,MainActivity.class);
                startActivity(intent);
/*
                databaseHandler.addDataOfUser(globalClass.getName(),globalClass.getGender(),globalClass.getDayOfMonth(),
                        globalClass.getMonth(),globalClass.getYear(),globalClass.getWeight(),globalClass.getHeightFeet(),
                        globalClass.getHeightInches(),globalClass.getSleepHour(),globalClass.getSleepHour(),globalClass.getWakeupHour(),
                        globalClass.getWakeupMin(),globalClass.getDrinkInterval());*/

            }
        });
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int Hour, int minute) {
     sleepHour= Hour;
        sleepminutes=minute;
        GlobalClass globalClass=(GlobalClass)getApplicationContext();

        String wakingtime1=sleepHour+":"+sleepminutes;
        SleepTime.setText(wakingtime1);

    }


}