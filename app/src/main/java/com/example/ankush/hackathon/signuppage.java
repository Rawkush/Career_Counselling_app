package com.example.ankush.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;

import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;




public class signuppage extends AppCompatActivity {

    private EditText uName,emailText,passwordText,confirmPasswordText;
    private FirebaseAuth mAuth;
    private TextView signIn;


    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuppage);

        mAuth=FirebaseAuth.getInstance();

        mProgress=new ProgressDialog(signuppage.this);

        uName=findViewById(R.id.username_field);
        emailText=findViewById(R.id.email_field);
        passwordText=findViewById(R.id.password_field);
        signIn=findViewById(R.id.signIn_Text);
        confirmPasswordText=findViewById(R.id.confirmPassword_field);





        Button signUp = findViewById(R.id.signup_button);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignup();

            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(signuppage.this,Signin.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();

            }
        });




    }


    private void startSignup() {

        final String username=uName.getText().toString().trim();
        String Email=emailText.getText().toString().trim();
        String password=passwordText.getText().toString().trim();
        String confirmPassword=confirmPasswordText.getText().toString().trim();

        if(username.isEmpty() || Email.isEmpty() || password.isEmpty()){

            Toast.makeText(signuppage.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();

        }

        else if(!password.equals(confirmPassword)){

            Toast.makeText(signuppage.this, "Passwords Do Not Match", Toast.LENGTH_SHORT).show();

        }
        else {


            mProgress.setMessage("Signing Up... Please Wait");
            mProgress.show();


            mAuth.createUserWithEmailAndPassword(Email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    mProgress.dismiss();

                    if (task.isSuccessful()) {

                        sendEmail();

                    }


                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(signuppage.this, e.getMessage(), Toast.LENGTH_LONG).show();

                }
            });
        }


    }


    private void sendEmail(){

        mProgress.setMessage("Sending Verification Mail");
        mProgress.show();

        FirebaseUser firebaseUser=mAuth.getCurrentUser();

        if(firebaseUser!=null){

            firebaseUser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {

                    mProgress.dismiss();

                    if(task.isSuccessful()){

                        Toast.makeText(signuppage.this, "Registration Successful, Please verify email sent", Toast.LENGTH_LONG).show();
                        mAuth.signOut();
                        finish();
                        startActivity(new Intent(signuppage.this,Signin.class));

                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(signuppage.this,e.getMessage(),Toast.LENGTH_LONG).show();

                }
            });

        }

    }



}

