package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.WindowCallbackWrapper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Locale;

public class WeightDialog extends AppCompatActivity {
    NumberPicker numberPickerWeight,numberPickerHeightFeet,numberPickerHeightInches;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_dialog);
        Button btn=findViewById(R.id.weightOk);
       //
        numberPickerWeight=findViewById(R.id.weightnumber);
        numberPickerWeight.setMaxValue(250);
        numberPickerWeight.setMinValue(30);


        //
        numberPickerHeightFeet=findViewById(R.id.HeightOfuserFeet);
        numberPickerHeightFeet.setMaxValue(10);
        numberPickerHeightFeet.setMinValue(2);

        //
        numberPickerHeightInches=findViewById(R.id.HeightOfuserinches);
        numberPickerHeightInches.setMinValue(0);
        numberPickerHeightInches.setMaxValue(11);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GlobalClass g=(GlobalClass)getApplicationContext();
                int Weight_of_User=numberPickerWeight.getValue();
                g.setWeight(Weight_of_User);
                int Height_feet=numberPickerHeightFeet.getValue();
                g.setHeightFeet(Height_feet);
                int Height_inches=numberPickerHeightInches.getValue();
                g.setHeightInches(Height_inches);
                Intent intent=new Intent(WeightDialog.this,WakeUpTimeInterval.class);
                startActivity(intent);
            }
        });
    }

    }
