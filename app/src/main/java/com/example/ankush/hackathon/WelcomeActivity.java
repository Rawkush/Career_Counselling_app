package com.example.ankush.hackathon;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class WelcomeActivity extends AppCompatActivity {

 private   Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                final Intent mainIntent = new Intent(WelcomeActivity.this, Signin.class);
                WelcomeActivity.this.startActivity(mainIntent);
                Handler handler = new Handler();
                WelcomeActivity.this.finish();





            }
        }, 2000);
        final Toast toast = Toast.makeText(getApplicationContext(), "Loading...", Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 1800);


    }

}
