package com.example.faraz.json;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Context context=this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String title,link,image,newstime,summary,image5;
    String jsonData;
    public class downloadeAble extends AsyncTask<String, Void, String>{

        @Override
        protected String doInBackground(String... urls) {
            String result="";
            URL url;
            HttpURLConnection connection=null;
            try {
                url=new URL(urls[0]);
                connection=(HttpURLConnection) url.openConnection();
                InputStream in=connection.getInputStream();
                connection.connect();
                InputStreamReader reader=new InputStreamReader(in);
                int data=reader.read();
                while(data != -1){
                    char creat=(char) data;
                    result+=creat;
                    data=reader.read();
                }
                return result;
            } catch (Exception e) {
                return null;
            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadeAble task=new downloadeAble();
        String result="";

        try {
            result=task.execute("http://13.88.190.220:8000/newslist/").get();
            jsonData=result;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        try {
            JSONObject jsonObj=new JSONObject(result);
            String rss=jsonObj.getString("results");
            JSONArray arr=new JSONArray(rss);
            for(int i=0;i<arr.length();++i){
                JSONObject jsonpart=arr.getJSONObject(i);
                title=jsonpart.getString("title");
                link=jsonpart.getString("link");
                image=jsonpart.getString("image");
                newstime=jsonpart.getString("newsTime");
                summary=jsonpart.getString("summary");




                userDbHelper=new UserDbHelper(context);
                sqLiteDatabase=userDbHelper.getWritableDatabase();
                userDbHelper.addinformation(title,link,image,newstime,summary,sqLiteDatabase);


                userDbHelper.close();
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void JsonDataDispaly(View view){

        Intent intent=new Intent(this,Display_List_View.class);
        intent.putExtra("Json_Data",jsonData);
        startActivity(intent);
    }

    }




