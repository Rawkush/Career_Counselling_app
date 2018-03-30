package com.example.ankush.hackathon;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class AlphabetDisplayListActivity extends Fragment {
private alphabetAdapter mAdapter;

    private ProgressDialog mProgress;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

     View view=   inflater.inflate(R.layout.activity_list_view, container,false);

     mProgress=new ProgressDialog(getContext());
    // setContentView(R.layout.activity_list_view);
      // LayoutInflater.inflate(R.layout.tab2, , false);
        // Find a reference to the {@link ListView} in the layout

        ListView dataListView = (ListView) view.findViewById(R.id.list);
        final ArrayList<data_with_link> temp= new ArrayList<>();
        // Create a new adapter that takes an empty list of s as input
        mAdapter = new alphabetAdapter(getContext(), new ArrayList<data_with_link>(),"AlphabetDisplayList");

        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface

       ListAsyncTask task = new ListAsyncTask();

        task.execute("https://career.webindia123.com/career/options/asp/alpha_listing.asp");

     //   ArrayList<data_with_link> a= AlphabetOrderDataExtraction.fetchData(("https://career.webindia123.com/career/options/asp/alpha_listing.asp"));
        // Set an item click listener on the ListView, which sends an intent to a web browser
        // to open a website with more information about the selected .
        mAdapter = new alphabetAdapter(getContext(), temp,"AlphabetDisplayList" );


          dataListView.setAdapter(mAdapter);

        dataListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Find the current  that was clicked on
                data_with_link currentdata = mAdapter.getItem(position);

                // Convert the String URL into a URI object (to pass into the Intent constructor)
            //    Uri careerListUri = Uri.parse(currentdata.getUrl());

                // Create a new intent to view the  URI
              //  Intent websiteIntent = new Intent(Intent.ACTION_VIEW, careerListUri);

                // Send the intent to launch a new activity
               // startActivity(websiteIntent);

               Intent intent = new Intent(getContext(), selectedCareerDetails.class);
                intent.putExtra("url",currentdata.getUrl());
                startActivity(intent);

            }
        });
        return view;


    }





    //assync task

    @SuppressLint("StaticFieldLeak")
    private  class ListAsyncTask extends AsyncTask<String, Void, ArrayList<data_with_link>> {

        @Override
        protected ArrayList<data_with_link> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            return AlphabetOrderDataExtraction.fetchData(urls[0],"AlphabetDisplayList");
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgress.setMessage("Loading...");
            mProgress.show();

        }

        @Override
        protected void onPostExecute(ArrayList<data_with_link> data) {
            // Clear the adapter of previous  data
            mAdapter.clear();

            //loading removing

            mProgress.dismiss();

            // If there is a valid list of s, then add them to the adapter's
            // data set. This will trigger the ListView to update.
            if (data != null && !data.isEmpty()) {
                mAdapter.addAll(data);
            }
        }
    }


}
