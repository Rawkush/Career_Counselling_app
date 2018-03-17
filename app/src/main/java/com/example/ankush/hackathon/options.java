package com.example.ankush.hackathon;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class options extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
    }

    public void alphabet(View view){
        Intent intent= new Intent(this,AlphabetDisplayListActivity.class);
        startActivity(intent);
    }

    public void after_ten(View view){

        Intent intent= new Intent(this,after_tenth.class);
        startActivity(intent);

    }


}
