package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;

public class Calorie extends AppCompatActivity {
    BoomMenuButton bmb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        bmb = findViewById(R.id.boomCalorie);

        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            if(i==0) {
                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.calorie)
                        .normalText("Calorie Table")
                        .subNormalText("You can view That")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent = new Intent(Calorie.this, CaloriePdf.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder);
            }
            else {
                HamButton.Builder builder = new HamButton.Builder()
                        .normalImageRes(R.drawable.calorie)
                        .normalText("BMI")
                        .subNormalText("")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent = new Intent(Calorie.this, BIM.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder);
            }
        }
        }
    }

