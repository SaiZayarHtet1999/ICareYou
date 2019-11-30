package com.cu.sai.saiboommenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrgames13.jimdo.splashscreen.App.SplashScreenBuilder;
import com.nightonke.boommenu.BoomButtons.HamButton;
import com.nightonke.boommenu.BoomButtons.OnBMClickListener;
import com.nightonke.boommenu.BoomButtons.SimpleCircleButton;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;

import java.time.Year;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
     TextView welcome;
    BoomMenuButton bmb;
    TextView textweight,textheight,textDob;
    public SQLiteDatabaseHandler databaseHandler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ////declaration
        GlobalClass globalClass=(GlobalClass)getApplicationContext();
        databaseHandler=new SQLiteDatabaseHandler(this);
        databaseHandler.addDataOfUser(globalClass.getName(),globalClass.getGender(),globalClass.getDayOfMonth(),
                globalClass.getMonth(),globalClass.getYear(),globalClass.getWeight(),globalClass.getHeightFeet(),
                globalClass.getHeightInches(),globalClass.getSleepHour(),globalClass.getSleepHour(),globalClass.getWakeupHour(),
                globalClass.getWakeupMin(),globalClass.getDrinkInterval());



        bmb=findViewById(R.id.boomWater);
       welcome=findViewById(R.id.welcome);
       textweight=findViewById(R.id.welcomeWeight);
       textheight=findViewById(R.id.welcomeHeight);
       textDob=findViewById(R.id.welcomeDate);
        int user_year=globalClass.getYear();
        Calendar lCal = Calendar.getInstance();
        int current_Year = lCal.get(Calendar.YEAR);
        int calculate_year=current_Year-user_year;
///temporary
welcome.setText("Hi Welcome "+globalClass.getName()+"("+globalClass.getGender()+")");
textDob.setText("Date Of Birth="+globalClass.getDayOfMonth()+"/"+globalClass.getMonth()+"/"+globalClass.getYear());
textweight.setText("Weight= "+globalClass.getWeight()+"lb "+calculate_year);
textheight.setText("Height="+globalClass.getHeightFeet()+" feet "+globalClass.getHeightInches()+" inches"+"\nInterval"+
        globalClass.getDrinkInterval());




        for (int i = 0; i < bmb.getPiecePlaceEnum().pieceNumber(); i++) {
            if(i==0){//Food Calorie
                HamButton.Builder builder1 =  new HamButton.Builder()
                        .normalImageRes(R.drawable.water)
                        .subNormalText("Water")
                        .normalText("Water Reminder")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent=new Intent(MainActivity.this,Water.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder1);
            }
            else if(i==1){//Food Calorie
                HamButton.Builder builder2 =  new HamButton.Builder()
                        .normalImageRes(R.drawable.calorie)
                        .subNormalText("Calorie")
                        .normalText("Calorie Calculator")
                        .listener(new OnBMClickListener() {
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent=new Intent(MainActivity.this,Calorie.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder2);
            }
            else if(i==2){//pill
                HamButton.Builder builder3 =  new HamButton.Builder()
                        .normalImageRes(R.drawable.pill)//dar ka logo a twat
                        .normalText("Pill")//dar ka logo bay ka title a gyi gyi
                        .subNormalText("this remind you to take your pill")//dar ka title a tayy sarr lay
                        .listener(new OnBMClickListener() {//dar ka button ko press yin  bar phyit ma ll so pee write htar tar
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent=new Intent(MainActivity.this,Pill.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder3);
            }
            else if(i==3){//wakeupReminder
                HamButton.Builder builder4 =  new HamButton.Builder()
                        .normalImageRes(R.drawable.ic_access_alarm_black_24dp)//dar ka logo a twat
                        .normalText("Alarm")//dar ka logo bay ka title a gyi gyi
                        .subNormalText("this need modify please check this")//dar ka title a tayy sarr lay
                        .listener(new OnBMClickListener() {//dar ka button ko press yin  bar phyit ma ll so pee write htar tar
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent=new Intent(MainActivity.this,WakeTime.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder4);
            }
            else if(i==4){//Setting
                HamButton.Builder builder3 =  new HamButton.Builder()
                        .normalImageRes(R.drawable.setting)//dar ka logo a twat
                        .normalText("Setting")//dar ka logo bay ka title a gyi gyi
                        .subNormalText("You can change here")//dar ka title a tayy sarr lay
                        .listener(new OnBMClickListener() {//dar ka button ko press yin  bar phyit ma ll so pee write htar tar
                            @Override
                            public void onBoomButtonClick(int index) {
                                Intent intent=new Intent(MainActivity.this,Setting.class);
                                startActivity(intent);
                            }
                        });
                bmb.addBuilder(builder3);
            }


        }

    }

}
