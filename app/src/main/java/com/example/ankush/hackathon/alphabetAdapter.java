package com.example.ankush.hackathon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Ankush
 */

public class alphabetAdapter extends ArrayAdapter<data_with_link> {

/*
    public class image{

        private Integer position;
        private ImageView imageView;
        private Bitmap bitmap=null;
        public image(Integer integer,ImageView imageView)
        {
            this.position=integer;
            this.imageView=imageView;
        }
        public image(Integer integer,ImageView imageView,Bitmap bitmap){
            this.bitmap=bitmap;
            this.position=integer;
            this.imageView=imageView;
        }

        public Integer getPosition(){
            return  position;
        }
        public ImageView getImageView(){
            return imageView;
        }
        public Bitmap getBitmap(){
            return bitmap;
        }
    }

*/
    private Context mContext;
    private View tempView;
    private String myActivityName;
    private ArrayList<data_with_link> detailsList = new ArrayList<>();

    public alphabetAdapter(@NonNull Context context, @NonNull ArrayList<data_with_link> objects,String ActivityNAme) {
        super(context,0, objects);
        mContext=context;
        detailsList= objects;
        myActivityName=ActivityNAme;
    }

    private int getMagnitudeColor(char Alphabet) {
        int ColorResourceId;


        switch (Alphabet) {

            case 'a':
            case 'A':
                ColorResourceId = R.color.A;
                break;
            case 'B':
            case 'b':
                ColorResourceId  = R.color.B;
                break;
            case 'c':
            case 'C':
                ColorResourceId  = R.color.C;
                break;
            case 'd':
            case 'D':
                ColorResourceId  = R.color.D;
                break;
            case 'e':
            case 'E':
                ColorResourceId  = R.color.E;
                break;
            case 'f':
            case 'F':
                ColorResourceId  = R.color.F;
                break;
            case 'g':
            case 'G':
                ColorResourceId  = R.color.G;
                break;
            case 'h':
            case 'H':
                ColorResourceId  = R.color.H;
                break;
            case 'i':
            case 'I':
                ColorResourceId  = R.color.I;
                break;
            case 'j':
            case 'J':
                ColorResourceId  = R.color.J;
                break;
            case 'k':
            case 'K':
                ColorResourceId  = R.color.K;
                break;
            case 'l':
            case 'L':
                ColorResourceId  = R.color.L;
                break;
            case 'm':
            case 'M':
                ColorResourceId  = R.color.M;
                break;
            case 'n':
            case 'N':
                ColorResourceId  = R.color.N;
                break;
            case 'o':
            case 'O':
                ColorResourceId  = R.color.O;
                break;
            case 'p':
            case 'P':
                ColorResourceId  = R.color.P;
                break;
            case 'q':
            case 'Q':
                ColorResourceId  = R.color.Q;
                break;
            case 'r':
            case 'R':
                ColorResourceId  = R.color.R;
                break;
            case 's':
            case 'S':
                ColorResourceId  = R.color.S;
                break;
            case 't':
            case 'T':
                ColorResourceId  = R.color.T;
                break;
            case 'u':
            case 'U':
                ColorResourceId  = R.color.U;
                break;
            case 'v':
            case 'V':
                ColorResourceId  = R.color.V;
                break;
            case 'w':
            case 'W':
                ColorResourceId  = R.color.W;
                break;
            case 'x':
            case 'X':
                ColorResourceId  = R.color.X;
                break;

            case 'Y':
            case 'y':
                ColorResourceId  = R.color.Y;
                break;
            case 'z':
            case 'Z':
                ColorResourceId  = R.color.Z;
                break;

            default:
                ColorResourceId  = R.color.A;
                break;
        }
        return ContextCompat.getColor(getContext(), ColorResourceId);
    }



//setting view

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //LayoutInflater myinflater= LayoutInflater.from(getContext());

        View listItem = convertView;
        data_with_link details = getItem(position);
      //  final String pic = details.getUrl();

        tempView= listItem;

        if(myActivityName.equals("AlphabetDisplayList")) {

                if (listItem == null)
                    listItem = LayoutInflater.from(mContext).inflate(R.layout.adapter, parent, false);

/*
            ListAsyncTask listAsyncTask = new ListAsyncTask();
            ImageView imageView = (ImageView) listItem.findViewById(R.id.listImage);
            image i = new image(position, imageView);
            listAsyncTask.execute(i);
*/
                TextView textView2 = (TextView) listItem.findViewById(R.id.name);

                                String s = null;
                if (details != null) {
                    s = String.valueOf(details.getAlphabets());

                    // textView1.setText(s);
                    // GradientDrawable magnitudeCircle = (GradientDrawable) textView1.getBackground();

                    textView2.setText(details.getTitle());
                    // Get the appropriate background color based on the current earthquake magnitude
                    //  int magnitudeColor = getMagnitudeColor(details.getAlphabets());

                    // Set the color on the magnitude circle
                    //  magnitudeCircle.setColor(magnitudeColor);
                }
        }else
        if(myActivityName.equals("ScholarshipListActivity")) {

            if (listItem == null)
                listItem = LayoutInflater.from(mContext).inflate(R.layout.scholarship_adapter, parent, false);

            TextView textView1 = (TextView) listItem.findViewById(R.id.scholar_letter);

            TextView textView2 = (TextView) listItem.findViewById(R.id.scholar_title);
            String s = null;
            if (details != null) {
                s = String.valueOf(details.getAlphabets());

                textView1.setText(s);
                GradientDrawable magnitudeCircle = (GradientDrawable) textView1.getBackground();

                textView2.setText(details.getTitle());
                // Get the appropriate background color based on the current earthquake magnitude
                int magnitudeColor = getMagnitudeColor(details.getAlphabets());

                // Set the color on the magnitude circle
                magnitudeCircle.setColor(magnitudeColor);
            }

        }

            return listItem;


    }






/**


    @SuppressLint("StaticFieldLeak")
    private  class ListAsyncTask extends AsyncTask< image, Void, image> {

        @Override
        protected image doInBackground(image... im) {
           if(im.length<1)
            return null;

           String initialUrl = "https://career.webindia123.com";
                Bitmap mIcon11 = null;
                try {

                    data_with_link data=getItem(im[0].position);

                    Document doc = Jsoup.connect(data.getUrl()).get();
                    // String title = doc.title();
                    //  Elements subcontainer = doc.select("div#subcontainer p");
                    Elements listCareer = doc.select("div.span_30 td");
                    //   Elements linkss = listCareer.select("a[href]");
                    Elements image = listCareer.select("img[src]");                //for image displaying
                    String urlForImage = image.attr("src");

                    // Elements s=doc.select("div#subcontainer h1");
                    //  temp.add(new data_with_link('a',s.text(),"head"));

                    InputStream in = new java.net.URL(initialUrl + urlForImage).openStream();

                    mIcon11 = BitmapFactory.decodeStream(in);

                    // publishProgress(mIcon11); // calling progressupdate method

//check here
                    im[0]= new image(im[0].getPosition(),im[0].getImageView(),mIcon11);


                } catch (IOException e) {
                    Log.i("a", "aa");
                }



            return  im[0];

        }


        @Override
        protected void onPostExecute(image data) {

            ImageView imageView=data.getImageView();
            imageView.setImageBitmap(data.getBitmap());
            // Clear the adapter of previous earthquake data
            // mAdapter.clear();

            // If there is a valid list of {@link Earthquake}s, then add them to the adapter's
            // data set. This will trigger the ListView to update.


        }
    }



/*
    @SuppressLint("StaticFieldLeak")
    private  class ListAsyncTask extends AsyncTask< ArrayList<data_with_link>, Void, ArrayList<data_with_link>> {


        @Override
        protected ArrayList<data_with_link> doInBackground(ArrayList<data_with_link>[] arrayLists) {
            if (arrayLists.length < 1) {
                return null;
            }


            String initialUrl = "https://career.webindia123.com";
            for (int i = 0; i <= arrayLists[0].size(); i++) {


                Bitmap mIcon11 = null;
                try {

                    data_with_link data = arrayLists[0].get(i);

                    Document doc = Jsoup.connect(data.getUrl()).get();
                    // String title = doc.title();
                    //  Elements subcontainer = doc.select("div#subcontainer p");
                    Elements listCareer = doc.select("div.span_30 td");
                    //   Elements linkss = listCareer.select("a[href]");
                    Elements image = listCareer.select("img[src]");                //for image displaying
                    String urlForImage = image.attr("src");

                    // Elements s=doc.select("div#subcontainer h1");
                    //  temp.add(new data_with_link('a',s.text(),"head"));
                    data = new data_with_link("ajshd");

                    InputStream in = new java.net.URL(initialUrl + urlForImage).openStream();

                    mIcon11 = BitmapFactory.decodeStream(in);

                   // publishProgress(mIcon11); // calling progressupdate method

//check here


                } catch (IOException e) {
                    Log.i("a", "aa");
                }


            }


            return arrayLists[0];

        }

        @Override
        protected void onPostExecute(ArrayList<data_with_link> data) {
            // Clear the adapter of previous data
           // mAdapter.clear();

            // If there is a valid list of, then add them to the adapter's
            // data set. This will trigger the ListView to update.

        }
    }


**/


}
