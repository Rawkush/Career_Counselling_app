package com.example.ankush.hackathon;

import java.net.URI;
import java.net.URL;

/**
 * Created by Ankush on 3/11/2018.
 */

public class data_with_link {

    private String title;
    private String aplhabet;
    private URL url;

public data_with_link(String aplhabet,String title, URL url){

    this.aplhabet=aplhabet;
    this.title=title;
    this.url=url;
}



public String getTitle(){
    return title;
}

public String getAplhabet(){
    return  aplhabet;
}


public URL getUrl(){
    return url;
}



}
