package com.example.ankush.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Class10 extends AppCompatActivity {
    private TextView signup,btn1,btn2,btn3,btn4,btn5;
private int a=0;
//TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class10);
        signup = (TextView) findViewById(R.id.textstream);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10.this,Class10streams.class);
                startActivity(i);
            }
        });
        btn1 = (TextView) findViewById(R.id.textdiploma);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10.this,tendiploma.class);
                startActivity(i);
            }
        });
        btn2 = (TextView) findViewById(R.id.textscholarship);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10.this,tenscholarships.class);
                startActivity(i);
            }
        });
        btn4 = (TextView) findViewById(R.id.text3);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10.this,tenshort.class);
                startActivity(i);
            }
        });
        btn5 = (TextView) findViewById(R.id.text4);
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Class10.this,Jobs.class);
                startActivity(i);
            }
        });

    }

}
