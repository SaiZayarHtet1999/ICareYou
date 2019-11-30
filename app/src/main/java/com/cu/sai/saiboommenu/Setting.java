package com.cu.sai.saiboommenu;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.jar.Attributes;

public class Setting extends AppCompatActivity {
    TextView NameSetting;
    TextView dateOfBirth;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        NameSetting=findViewById(R.id.UserNameSetting);
        GlobalClass g=(GlobalClass)getApplicationContext();
        imageView=findViewById(R.id.GeneralPhotoSetting);
        if(g.getGender()=="Woman"){
            imageView.setBackgroundResource(R.drawable.woman);
        }
        else{
            imageView.setBackgroundResource(R.drawable.man);
        }
        NameSetting.setText(g.getName());
dateOfBirth=findViewById(R.id.DateOfBirthSetting);
dateOfBirth.setText(g.getDayOfMonth()+"/"+g.getMonth()+"/"+g.getYear());
    }
}
