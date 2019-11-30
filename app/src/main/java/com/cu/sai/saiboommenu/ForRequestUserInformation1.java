package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RadioButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ForRequestUserInformation1 extends AppCompatActivity implements  DatePickerDialog.OnDateSetListener {
    RadioButton radioButton1, radioButton2;
    int day,month,year;
    TextView BirthdateButton;
    Button NextButton;
    TextView  name;
    String nameofuser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_for_request_user_information1);


        final GlobalClass globalClass = (GlobalClass) getApplicationContext();
        //declaration
        radioButton1 = findViewById(R.id.ManRadio);
        radioButton2 = findViewById(R.id.WomanRadio);
        BirthdateButton = findViewById(R.id.DateOfBirth);
        NextButton = findViewById(R.id.NextButton);
        name = findViewById(R.id.UserNameDialog);


        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder nameDialog = new AlertDialog.Builder(ForRequestUserInformation1.this);
                final View NameView = getLayoutInflater().inflate(R.layout.name_dialog, null);
                nameDialog.setView(NameView)
                        .setTitle("Name")
                        .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                EditText editText = NameView.findViewById(R.id.UserName);
                                nameofuser=editText.getText().toString();

                                name.setText(editText.getText().toString());
                            }
                        });
                AlertDialog dialog = nameDialog.create();
                dialog.show();
            }
        });

        //for Request Birthdate
        BirthdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });

        //Next Button
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent=new Intent(ForRequestUserInformation1.this,WeightDialog.class);
               startActivity(intent);
                globalClass.setName(nameofuser);
                ///dar ko pyan lope kyi ohm
                if (radioButton1.isChecked()) {
                    globalClass.setGender("Man");
                } else if (radioButton2.isChecked()) {
                    globalClass.setGender("Woman");
                }
                globalClass.setDayOfMonth(day);
                globalClass.setMonth(month);
                globalClass.setYear(year);

            }
        });

    }

    public void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (DatePickerDialog.OnDateSetListener) this,
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)


        );

        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year1, int month1, int dayOfMonth1) {
        month1++;
        String date = dayOfMonth1 + "/" + month1 + "/" + year1;
        day=dayOfMonth1;
        month=month1;
        year=year1;
        GlobalClass globalClass = (GlobalClass) getApplicationContext();

        BirthdateButton.setText(date);
    }
}
