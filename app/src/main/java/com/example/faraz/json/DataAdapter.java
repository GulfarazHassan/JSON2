package com.example.faraz.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Faraz on 29/07/2016.
 */
public class DataAdapter extends ArrayAdapter {
    List list=new ArrayList();
    public DataAdapter(Context context, int resource) {
        super(context, resource);
    }

    static class LayoutHandler{

        TextView title2,link2,newstime2,summary2;
        ImageView image2;

    }

    @Override
    public void add(Object object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View raw=convertView;
        LayoutHandler layoutHandler;
        if(raw == null){
            LayoutInflater layoutInflater=(LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            raw=layoutInflater.inflate(R.layout.row_layout,parent,false);
            layoutHandler=new LayoutHandler();
            layoutHandler.title2=(TextView) raw.findViewById(R.id.title11);
            layoutHandler.link2=(TextView) raw.findViewById(R.id.link22);
            layoutHandler.newstime2=(TextView) raw.findViewById(R.id.newstime11);
            layoutHandler.summary2=(TextView) raw.findViewById(R.id.summary11);
            layoutHandler.image2=(ImageView) raw.findViewById(R.id.image11);
            raw.setTag(layoutHandler);
        }
        else{
            layoutHandler=(LayoutHandler) raw.getTag();

        }
        DataProvider dataProvider= (DataProvider) this.getItem(position);
        layoutHandler.title2.setText(dataProvider.getTitle22());
        layoutHandler.link2.setText(dataProvider.getLink22());
        layoutHandler.newstime2.setText(dataProvider.getNewstime22());
        layoutHandler.summary2.setText(dataProvider.getSummary22());


        return raw;
    }

    }

