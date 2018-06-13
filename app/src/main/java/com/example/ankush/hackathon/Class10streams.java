package com.example.ankush.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;


public class Class10streams extends AppCompatActivity {
    private TextView btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class10streams);
        btn1 = (TextView) findViewById(R.id.text1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10streams.this,coursexplation.class);
                startActivity(i);
            }
        });
        btn2 = (TextView) findViewById(R.id.text2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10streams.this,coursexplation.class);
                startActivity(i);
            }
        });
        btn3 = (TextView) findViewById(R.id.text8);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10streams.this,coursexplation.class);
                startActivity(i);
            }
        });
    }
}
