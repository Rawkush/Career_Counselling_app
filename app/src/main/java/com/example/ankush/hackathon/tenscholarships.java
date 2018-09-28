package com.example.ankush.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

public class tenscholarships extends AppCompatActivity {
FoldingCell fc1,fc;
private Button eligible,benefits, click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenscholarships);


        fc1=(FoldingCell) findViewById(R.id.folding_cell);
        fc=(FoldingCell) findViewById(R.id.folding_cell1);
        eligible=(Button)findViewById(R.id.elibtn);
        benefits=(Button)findViewById(R.id.benefits);
        click=(Button)findViewById(R.id.click);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                WebView web = new WebView(tenscholarships.this);
                setContentView(web);
                web.loadUrl("https://scholarships.gov.in/");


            }
        });
        benefits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
        eligible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc1.toggle(false);
            }
        });
    }
}
