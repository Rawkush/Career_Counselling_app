package com.example.ankush.hackathon;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.ramotion.foldingcell.FoldingCell;

public class tenshort extends AppCompatActivity {
    FoldingCell fc;
    Button digital,Nptel,PMKVY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tenshort);
        fc=(FoldingCell)findViewById(R.id.folding_cell2);
        digital=(Button)findViewById(R.id.digital);
        digital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fc.toggle(false);
            }
        });
        /*scope.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(tenshort.this,scope.class));
            }
        }); */

        PMKVY=(Button)findViewById(R.id.pmkvy);
        PMKVY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView web = new WebView(tenshort.this);
                setContentView(web);
                web.loadUrl("http://pmkvyofficial.org/index.aspx");
            }
        });
        Nptel=(Button)findViewById(R.id.nptel);
        Nptel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WebView web = new WebView(tenshort.this);
                setContentView(web);
                web.loadUrl("http://nptel.ac.in");
            }
        });
    }
}
