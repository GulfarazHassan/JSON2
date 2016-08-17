package com.example.faraz.json;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class Display_List_View  extends AppCompatActivity {
    ListView listview;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    DataAdapter list_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display__list__view);
        listview = (ListView) findViewById(R.id.listview);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        list_adapter=new DataAdapter(getApplicationContext(),R.layout.row_layout);
        listview.setAdapter(list_adapter);
        cursor = userDbHelper.readinformation(sqLiteDatabase);
        if (cursor.moveToFirst()) {

            do {
                String title3,link3,image3,newstime3,summary3;
                title3=cursor.getString(0);
                link3=cursor.getString(1);
                image3=cursor.getString(2);
                newstime3=cursor.getString(3);
                summary3=cursor.getString(4);
                DataProvider dataProvider=new DataProvider(title3,link3,image3,newstime3,summary3);
                list_adapter.add(dataProvider);

            } while (cursor.moveToNext());
        }
    }
}
