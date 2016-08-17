package com.example.faraz.json;

import android.graphics.Bitmap;

/**
 * Created by Faraz on 28/07/2016.
 */
public class Data {

    String name,text,ID;
    Bitmap image;
    public Data(String name, String txt,String id,Bitmap image){

        this.setName(name);
        this.setTxt(txt);
        this.setId(id);
        this.setimg(image);
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getTxt(){
        return text;
    }
    public void setTxt(String text){
        this.text=text;
    }
    public String getId(){
        return ID;
    }
    public void setId(String ID){
        this.ID=ID;
    }
    public Bitmap getimg(){
        return image;
    }
    public void setimg(Bitmap img){
        this.image=img;
    }
}
