package com.example.ankush.hackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Ankush on 3/23/2018.
 */

public class scholarshipByOrder extends Fragment implements View.OnClickListener {

    private Button button1,button2,button3,button4;
    private LinearLayout linearLayout;
    private String container=null;
    private String url="https://scholarships.gov.in";
    private ListAsyncTask listAsyncTask=new ListAsyncTask();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.scholarship_by_order,container,false);

        button1=(Button) view.findViewById(R.id.central_scheme);
        button1.setOnClickListener(this);
        button2=(Button) view.findViewById(R.id.ugc_scheme);
        button2.setOnClickListener(this);
        button3=(Button) view.findViewById(R.id.aicte_scheme);
        button3.setOnClickListener(this);
        button4=(Button) view.findViewById(R.id.state_scheme);
        button4.setOnClickListener(this);

        return view;
    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.central_scheme:

                container="div#CentralSchemes.w3-container w3-border scheme tr";
                listAsyncTask.execute(container);
                // code for button when user clicks buttonOne.
                break;

            case R.id.ugc_scheme:

                container="div#CentralSchemes.w3-container w3-border scheme tr";
                listAsyncTask.execute(container);
                // do your code
                break;

            case R.id.aicte_scheme:

                container="div#CentralSchemes.w3-container w3-border scheme tr";
                listAsyncTask.execute(container);
                // do your code
                break;

            case R.id.state_scheme:

                container="div#CentralSchemes.w3-container w3-border scheme tr";
                listAsyncTask.execute(container);
                // do your code
                break;
            default:
                break;
        }

    }


    @SuppressLint("StaticFieldLeak")
    private  class ListAsyncTask extends AsyncTask<String, Void, ArrayList<data_with_link>> {




        @Override
        protected ArrayList<data_with_link> doInBackground(String... container) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (container.length < 1 || container[0] == null) {
                return null;
            }

            ArrayList<data_with_link> temp = new ArrayList<>();
            String initialUrl = "https://career.webindia123.com";

            try {


                Document doc = Jsoup.connect(url).get();
                // String title = doc.title();
                // selecting all td rows of the container
                Elements subcontainer = doc.select(container[0]);
                Elements listCareer = doc.select("div.span_30 td");
                Elements linkss = listCareer.select("a[href]");
                Elements header=subcontainer.select("header.type-2");
                int i=0;
                for (Element link : subcontainer) {
                    //copiyng 4 url options available

                   // temp.add(new data_with_link(link.text().charAt(0),link.text(), initialUrl + link.attr("href")));
                    Log.i("lol; ",link.attr("href"));

                }

            } catch (IOException e) {
                Log.i("a","aa");
            }



            return temp;


        }
        /*
                 void publishProgress(Bitmap bitmap) {

                    imageView.setImageBitmap(bitmap);
                }
        */
        @Override
        protected void onPostExecute(ArrayList<data_with_link> data) {
            // Clear the adapter of previous earthquake data







        }



    }


}
