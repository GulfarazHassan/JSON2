package com.example.faraz.json;

/**
 * Created by Faraz on 11/08/2016.
 */
public class DataProvider {

    protected String title22;
    protected String link22;
    protected String image22;
    protected String newstime22;
    protected String summary22;


    public DataProvider(String t, String l, String i, String n, String s){

        this.title22 = t;
        this.link22 = l;
        this.image22 = i;
        this.newstime22 = n;
        this.summary22 = s;
    }

    public String getTitle22() {
        return title22;
    }

    public void setTitle22(String title22) {
        this.title22 = title22;
    }

    public String getSummary22() {
        return summary22;
    }

    public void setSummary22(String summary22) {
        this.summary22 = summary22;
    }

    public String getNewstime22() {
        return newstime22;
    }

    public void setNewstime22(String newstime22) {
        this.newstime22 = newstime22;
    }

    public String getImage22() {
        return image22;
    }

    public void setImage22(String image22) {
        this.image22 = image22;
    }

    public String getLink22() {
        return link22;
    }

    public void setLink22(String link22) {
        this.link22 = link22;
    }
}
