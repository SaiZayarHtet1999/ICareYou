package com.cu.sai.saiboommenu;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.linroid.filtermenu.library.FilterMenu;
import com.linroid.filtermenu.library.FilterMenuLayout;
import com.naylalabs.semiradialmenu.MenuItemView;
import com.naylalabs.semiradialmenu.RadialMenuView;
import com.naylalabs.semiradialmenu.RadialMenuView.RadialMenuListener;

import java.util.ArrayList;

import me.itangqi.waveloadingview.WaveLoadingView;

public class Water extends AppCompatActivity implements RadialMenuListener {
WaveLoadingView waveLoadingView;
    public static int drunk_water_amount=0;
    RadialMenuView radialMenuView;
    static int amount_of_water_in_mililitre=0;
    double drinkamount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);
       GlobalClass globalClass=(GlobalClass)getApplicationContext();

       TextView textView=findViewById(R.id.WaterTitle);
       textView.setText(globalClass.getName());
        waveLoadingView=findViewById(R.id.AmountOfWater);
        double weight_in_pound=globalClass.getWeight();
       double weight_in_kg=weight_in_pound/2.2;
       double amount_of_water_in_litre=weight_in_kg/30;
        amount_of_water_in_mililitre= (int) (amount_of_water_in_litre*1000);


       String amount="you have to drink"+amount_of_water_in_mililitre;
       waveLoadingView.setTopTitle(amount);


        waveLoadingView.setProgressValue(globalClass.getDrunkAmount());

        waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre);
      radialMenuView = findViewById(R.id.radial_menu_view);
        Button button = findViewById(R.id.btnaddwater);

        MenuItemView itemOne = new MenuItemView(this ,"Ask Questions",R.drawable.pizza, R.color.Ocean);
        MenuItemView itemTwo = new MenuItemView(this,"Friends",R.drawable.water, R.color.Ocean);
        MenuItemView itemThree = new MenuItemView(this,"Gallery", R.drawable.ic_access_alarm_black_24dp, R.color.Ocean);
        MenuItemView itemFour = new MenuItemView(this,"Settings", R.drawable.sleep, R.color.Ocean);
        MenuItemView itemFive = new MenuItemView(this, "Profile", R.drawable.setting, R.color.Ocean);
        ArrayList<MenuItemView> items = new ArrayList<>();
        items.add(itemOne);
        items.add(itemTwo);
        items.add(itemThree);
        items.add(itemFour);
        items.add(itemFive);
        radialMenuView.setListener(this);
        radialMenuView.setMenuItems(items);
        radialMenuView.setCenterView(button);
        radialMenuView.setInnerCircle(false, R.color.white);

        radialMenuView.setOffset(10);
        radialMenuView.build();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showClose(view);
            }
        });

    }

    public void showClose(View view) {
        radialMenuView.show();
    }

    @Override
    public void onItemClicked(int i) {
        if(i==0) {//for 50ml


            GlobalClass g=(GlobalClass)getApplicationContext();
            drinkamount=g.getDrunkAmountinOneTime()+50;
       double drunk=(drinkamount*100)/amount_of_water_in_mililitre;
       g.setDrunkAmountinOneTime((int) drinkamount);
       waveLoadingView.setTopTitle(drunk+"");
       waveLoadingView.setProgressValue((int) drunk);
       g.setDrunkAmount((int) drunk);
            waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre+"ml");
            Toast.makeText(this, "You have drunk "+drinkamount+"millilitre", Toast.LENGTH_SHORT).show();
        }
        if(i==1) {//for 100ml


            GlobalClass g=(GlobalClass)getApplicationContext();
            drinkamount=g.getDrunkAmountinOneTime()+100;
            double drunk=(drinkamount*100)/amount_of_water_in_mililitre;
            g.setDrunkAmountinOneTime((int) drinkamount);
            waveLoadingView.setTopTitle(drunk+"");
            waveLoadingView.setProgressValue((int) drunk);
            g.setDrunkAmount((int) drunk);
            waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre+"ml");
            Toast.makeText(this, "You have drunk "+drinkamount+"millilitre", Toast.LENGTH_SHORT).show();
        }
        if(i==2) {//for 150ml


            GlobalClass g=(GlobalClass)getApplicationContext();
            drinkamount=g.getDrunkAmountinOneTime()+150;
            double drunk=(drinkamount*100)/amount_of_water_in_mililitre;
            g.setDrunkAmountinOneTime((int) drinkamount);
            waveLoadingView.setTopTitle(drunk+"");
            waveLoadingView.setProgressValue((int) drunk);
            g.setDrunkAmount((int) drunk);
            waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre+"ml");
            Toast.makeText(this, "You have drunk "+drinkamount+"millilitre", Toast.LENGTH_SHORT).show();
        }
        if(i==3) {//for 200ml


            GlobalClass g=(GlobalClass)getApplicationContext();
            drinkamount=g.getDrunkAmountinOneTime()+200;
            double drunk=(drinkamount*100)/amount_of_water_in_mililitre;
            g.setDrunkAmountinOneTime((int) drinkamount);
            waveLoadingView.setTopTitle(drunk+"");
            waveLoadingView.setProgressValue((int) drunk);
            g.setDrunkAmount((int) drunk);
            waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre+"ml");
            Toast.makeText(this, "You have drunk "+drinkamount+"millilitre", Toast.LENGTH_SHORT).show();
        }
        if(i==4) {//for 250ml


            GlobalClass g=(GlobalClass)getApplicationContext();
            drinkamount=g.getDrunkAmountinOneTime()+250;
            double drunk=(drinkamount*100)/amount_of_water_in_mililitre;
            g.setDrunkAmountinOneTime((int) drinkamount);
            waveLoadingView.setTopTitle(drunk+"");
            waveLoadingView.setProgressValue((int) drunk);
            g.setDrunkAmount((int) drunk);
            waveLoadingView.setCenterTitle(waveLoadingView.getProgressValue()+"% /"+amount_of_water_in_mililitre+"ml");
            Toast.makeText(this, "You have drunk "+drinkamount+"millilitre", Toast.LENGTH_SHORT).show();
        }


    }
}
