package com.cu.sai.saiboommenu;

import android.app.Application;

import java.util.Date;

public class GlobalClass extends Application {
    private String Name;
    private String Gender;
    private int Year;
    private int Month;
    private int dayOfMonth;
    private int Weight;
    private int HeightFeet;
    private int HeightInches;
    private int SleepHour;
    private int SleepMinute;
    private int wakeupHour;
    private int WakeupMin;
    private int DrinkInterval;
    private int EatingInterval;
    private int drunkAmount;

    public int getDrunkAmountinOneTime() {
        return drunkAmountinOneTime;
    }

    public void setDrunkAmountinOneTime(int drunkAmountinOneTime) {
        this.drunkAmountinOneTime = drunkAmountinOneTime;
    }

    private int drunkAmountinOneTime;

    public int getDrunkAmount() {
        return drunkAmount;
    }

    public void setDrunkAmount(int drunkAmount) {
        this.drunkAmount = drunkAmount;
    }

    public int getSleepHour() {
        return SleepHour;
    }

    public void setSleepHour(int sleepHour) {
        SleepHour = sleepHour;
    }

    public int getSleepMinute() {
        return SleepMinute;
    }

    public void setSleepMinute(int sleepMinute) {
        SleepMinute = sleepMinute;
    }

    public int getWakeupHour() {
        return wakeupHour;
    }

    public void setWakeupHour(int wakeupHour) {
        this.wakeupHour = wakeupHour;
    }

    public int getWakeupMin() {
        return WakeupMin;
    }

    public void setWakeupMin(int wakeupMin) {
        WakeupMin = wakeupMin;
    }

    public int getDrinkInterval() {
        return DrinkInterval;
    }

    public void setDrinkInterval(int drinkInterval) {
        DrinkInterval = drinkInterval;
    }

    public int getEatingInterval() {
        return EatingInterval;
    }

    public void setEatingInterval(int eatingInterval) {
        EatingInterval = eatingInterval;
    }


    public int getHeightFeet() {
        return HeightFeet;
    }

    public void setHeightFeet(int heightFeet) {
        HeightFeet = heightFeet;
    }

    public int getHeightInches() {
        return HeightInches;
    }

    public void setHeightInches(int heightInches) {
        HeightInches = heightInches;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    public int getMonth() {
        return Month;
    }

    public void setMonth(int month) {
        Month = month;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }


    public void setGender(String gender) {
        Gender = gender;
    }

    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

}
