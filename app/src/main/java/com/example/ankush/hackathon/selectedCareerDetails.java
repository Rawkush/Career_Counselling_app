
package com.example.ankush.hackathon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class selectedCareerDetails extends AppCompatActivity {
private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_career_details);
        Intent i= getIntent();
        String url = i.getStringExtra("url");
        Log.i("jhs",url);

        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
        ListAsyncTask task = new ListAsyncTask();
        task.execute(url);



    }






    @SuppressLint("StaticFieldLeak")
    private  class ListAsyncTask extends AsyncTask<String, Void, ArrayList<data_with_link>> {

        @Override
        protected ArrayList<data_with_link> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

             ArrayList<data_with_link> temp = new ArrayList<>();

            try {
                Document doc = Jsoup.connect(urls[0]).get();
                // String title = doc.title();
                Elements subcontainer = doc.select("div#subcontainer");
                Elements listCareer = doc.select("div.span_30 td");
                Elements linkss = listCareer.select("a[href]");


                for (Element link : linkss) {


                    String initialUrl = "https://career.webindia123.com";
                    //copiyng 4 url options available
                    temp.add(new data_with_link(link.text().charAt(0),link.text(), initialUrl + link.attr("href")));
                    Log.i("lol; ",temp.get(0).getTitle());

                }

                temp.add(new data_with_link('a',subcontainer.text(),""));

            } catch (IOException e) {
                Log.i("a","aa");
            }



            return temp;


        }

        @Override
        protected void onPostExecute(ArrayList<data_with_link> data) {
            // Clear the adapter of previous earthquake data

            for(int i=0; i<data.size()  ;i++){

                if((i+1)==data.size()){
                    TextView textView= new TextView(getBaseContext());
                    textView.setId(i);
                    textView.setText(data.get(i).getTitle());
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.D));
                    linearLayout.addView(textView);
                    break;
                }else
                {
                   final String url=data.get(i).getUrl();
                    TextView textView= new TextView(getBaseContext());
                    textView.setId(i);
                    textView.setTextColor(ContextCompat.getColor(getBaseContext(), R.color.colorPrimary));
                    textView.setText(data.get(i).getTitle());
                    linearLayout.addView(textView);
                    textView.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
Log.i("jdjshdh","asjbdkjkadbbhahb");
                            Intent intent = new Intent(getApplicationContext(), selectedCareerDetails.class);
                            intent.putExtra("url",url);
                            startActivity(intent);
                            // Log.i("TAG", "The index is" + index);
                        }
                    });
Log.i("ahghsjdga","ajshdjajh");

                }


            }


        }
    }



}
