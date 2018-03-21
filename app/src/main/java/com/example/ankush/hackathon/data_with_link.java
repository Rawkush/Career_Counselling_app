package com.example.ankush.hackathon;

import android.graphics.Bitmap;

/**
 * Created by Ankush on 3/11/2018.
 */

public class data_with_link {

    private String title;
    private char alphabets;
    private String url;
    private String picUrl="null";

public data_with_link(char alphabets, String title, String url,String picUrl){

    this.alphabets =alphabets;
    this.title=title;
    this.url=url;
    this.picUrl=picUrl;
}
    public data_with_link(char alphabets, String title, String url){

        this.alphabets =alphabets;
        this.title=title;
        this.url=url;
        this.picUrl=picUrl;
    }

    public data_with_link( String url){
        this.picUrl=picUrl;
    }

public String getTitle(){
    return title;
}

public char getAlphabets(){
    return alphabets;
}


public String getUrl(){
    return url;
}

public String getPicUrl(){
    return  picUrl;
}


}
