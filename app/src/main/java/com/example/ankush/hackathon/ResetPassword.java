package com.example.ankush.hackathon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;


public class ResetPassword extends AppCompatActivity {


    private EditText passwordResetMail;
    private FirebaseAuth mAuth;
    private ProgressDialog mProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mProgress=new ProgressDialog(ResetPassword.this);

        mAuth=FirebaseAuth.getInstance();

        TextView goToSignIn=findViewById(R.id.backToSignIn);
        passwordResetMail=findViewById(R.id.emailResetPassword);

        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                startActivity(new Intent(ResetPassword.this,Signin.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });

        Button sendEmail=findViewById(R.id.btnSendEmail);

        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email=passwordResetMail.getText().toString().trim();

                if(email.isEmpty()) {

                    Toast.makeText(ResetPassword.this, "Please enter your registered email", Toast.LENGTH_SHORT).show();

                }else{

                    mProgress.setMessage("Sending Email...");
                    mProgress.show();

                    mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            mProgress.dismiss();

                            if(task.isSuccessful()){

                                Toast.makeText(ResetPassword.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(ResetPassword.this,Signin.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

                            }

                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {

                            Toast.makeText(ResetPassword.this, e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });

                }

            }
        });

    }
}
