package com.example.ankush.hackathon;

/**
 * Created by Ankush on 3/11/2018.
 */

public class data_with_link {

    private String title;
    private char alphabets;
    private String url;

public data_with_link(char alphabets, String title, String url){

    this.alphabets =alphabets;
    this.title=title;
    this.url=url;
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



}
