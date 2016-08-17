package com.example.faraz.json;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Faraz on 11/08/2016.
 */
public class UserDbHelper extends SQLiteOpenHelper {

    public static final String Data_Base_Name="DataBase.DB";
    public static final int DataBase_Version=1;
    public static final String CREAT_QUREY=
            "create table "+ userContract.NewUserInfo.Table_Name+" ("+ userContract.NewUserInfo.title+" TEXT,"+ userContract.NewUserInfo.link+
                    " TEXT,"+ userContract.NewUserInfo.image+" TEXT,"+ userContract.NewUserInfo.newstime +" TEXT,"+ userContract.NewUserInfo.summary +" TEXT);";
    UserDbHelper(Context context){
        super(context,Data_Base_Name,null,DataBase_Version);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAT_QUREY);
        Log.i("DataBase Table ","is created");
    }

    public void addinformation(String title1, String link1, String image1, String newstime1, String summary1, SQLiteDatabase db){

        ContentValues contentValues=new ContentValues();
        contentValues.put(userContract.NewUserInfo.title,title1);
        contentValues.put(userContract.NewUserInfo.link,link1);
        contentValues.put(userContract.NewUserInfo.image,image1);
        contentValues.put(userContract.NewUserInfo.newstime,newstime1);
        contentValues.put(userContract.NewUserInfo.summary,summary1);
        db.insert(userContract.NewUserInfo.Table_Name,null,contentValues);
        Log.i("One row is "," Inserted");
    }

    public Cursor readinformation(SQLiteDatabase db){
        Cursor cursor;
        String[] projections={userContract.NewUserInfo.title,userContract.NewUserInfo.link,
                userContract.NewUserInfo.image,userContract.NewUserInfo.newstime,userContract.NewUserInfo.summary};
        cursor=db.query(userContract.NewUserInfo.Table_Name,projections,null,null,null,null,null);
        return cursor;

    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

