package com.cu.sai.saiboommenu;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class SQLiteDatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_HANDLER=1;
    private static final String DATABASE_NAME="USER_INFO_DATABASE";
    private static final String TABLES="USER_INFO_TABLES";

    private static final String USER_NAME="USER_NAME";
    private static final String USER_GENDER="USER_GENDER";

    private static final String USER_DATE="USER_DATE";//int
    private static final String USER_MONTH="USER_MONTH";//
    private static final String USER_YEAR="USER_YEAR";//

    private static final String USER_WEIGHT="USER_WEIGHT";//

    private static final String USER_HEIGHT_FEET="USER_HEIGHT_FEET";//
    private static final String USER_HEIGHT_INCHES="USER_HEIGHT_INCHES";//

    private static final String USER_SLEEP_HOUR="USER_IUSER_SLEEP_HOURNFO";//
    private static final String USER_SLEEP_MINUTE="USER_SLEEP_MINUTE";//

    private static final String USER_WAKEUP_HOUR="USER_WAKEUP_HOUR";//
    private static final String USER_WAKE_UP_MIN="USER_WAKE_UP_MIN";//

    private static final String USER_DRINK_INTERVAL="USER_DRINK_INTERVAL";//

    private static final String USER_EATING_INTERVAL="USER_EATING_INTERVAL";//

    private static final String [] columns={USER_NAME,USER_GENDER,USER_DATE,USER_MONTH,USER_YEAR,USER_WEIGHT,
                                            USER_HEIGHT_FEET,USER_HEIGHT_INCHES,USER_SLEEP_HOUR,USER_SLEEP_MINUTE,
                                            USER_WAKEUP_HOUR,USER_WAKE_UP_MIN,USER_DRINK_INTERVAL,USER_EATING_INTERVAL};

    public SQLiteDatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null,DATABASE_HANDLER);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String CREATE_TABLE="CREATE TABLE "+TABLES+"("+USER_NAME+" TEXT, "+USER_GENDER+" TEXT, "+USER_DATE+" INTEGER, "+
                            USER_MONTH+" INTEGER, "+USER_YEAR+" INTEGER, "+USER_WEIGHT+" INTEGER, "+USER_HEIGHT_FEET+" INTEGER, "+
                USER_HEIGHT_INCHES+" INTEGER, "+USER_SLEEP_HOUR+" INTEGER, "+USER_SLEEP_MINUTE+" INTEGER, "+USER_WAKEUP_HOUR+" INTEGER, "+
                USER_WAKE_UP_MIN+" INTEGER, "+USER_DRINK_INTERVAL+" INTEGER, "+USER_EATING_INTERVAL+" INTEGER)";
        sqLiteDatabase.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLES);
        this.onCreate(sqLiteDatabase);
    }
    public void addDataOfUser(String name,String gender,int dayofbirth,int month,int year,int weight,
                              int heightfeet, int heightinches,int sleephour,int sleepMin,int wakeHour,int wakeMin,
                              int drink){
        SQLiteDatabase database=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(USER_NAME,name);
        contentValues.put(USER_GENDER,gender);
        contentValues.put(USER_DATE,dayofbirth);
        contentValues.put(USER_MONTH,month);
        contentValues.put(USER_YEAR,year);
        contentValues.put(USER_WEIGHT,weight);
        contentValues.put(USER_HEIGHT_FEET,heightfeet);
        contentValues.put(USER_HEIGHT_INCHES,heightinches);
        contentValues.put(USER_SLEEP_HOUR,sleephour);
        contentValues.put(USER_SLEEP_MINUTE,sleepMin);
        contentValues.put(USER_WAKEUP_HOUR,wakeHour);
        contentValues.put(USER_WAKE_UP_MIN,wakeMin);
        contentValues.put(USER_DRINK_INTERVAL,drink);
        database.insert(TABLES, null, contentValues);
        database.close();

    }
    //retrieving data
    public Cursor getdataname(){
SQLiteDatabase db=this.getWritableDatabase();

        return db.rawQuery("select * from "+TABLES,null);
    }

}

