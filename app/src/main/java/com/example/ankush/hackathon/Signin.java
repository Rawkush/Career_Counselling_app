package com.example.ankush.hackathon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.app.ProgressDialog;
import android.content.Intent;

import android.support.annotation.NonNull;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;

import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

import java.io.FileOutputStream;


public class Signin extends AppCompatActivity {


    private EditText emailText,passwordText;
    private TextView signUp;
    String fileName="file.txt";
    private ProgressDialog mProgress;

    private FirebaseAuth mAuth;

    private GoogleSignInClient mGoogleSignInClient;
    private static final int RC_SIGN_IN=2;
    private SignInButton googleButton;



    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        mAuth=FirebaseAuth.getInstance();

        googleButton=findViewById(R.id.googleSignInBtn);


        mProgress=new ProgressDialog(Signin.this);

        emailText=findViewById(R.id.emailSignIn);
        passwordText=findViewById(R.id.passwordSignIn);
        signUp=findViewById(R.id.signUp_Text);



        final Button signIn=findViewById(R.id.signInButton);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startSignIn();

            }
        });


        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                signIn();

            }
        });



        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Signin.this,signuppage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                finish();

            }
        });


        TextView forgotPassword=findViewById(R.id.forgotPasswordField);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(Signin.this,ResetPassword.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));

            }
        });



        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

    }


    private void startSignIn() {

        String email=emailText.getText().toString().trim();
        String password=passwordText.getText().toString().trim();

        if(email.isEmpty() || password.isEmpty()){

            Toast.makeText(Signin.this, "Please Fill All Fields", Toast.LENGTH_SHORT).show();

        }else{

            mProgress.setMessage("Signing In...Please Wait");
            mProgress.show();

            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    mProgress.dismiss();

                    if(task.isSuccessful()){

                        checkEmailVerification();

                    }

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {

                    Toast.makeText(Signin.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();

                }
            });

        }

    }

    private void checkEmailVerification(){

        FirebaseUser firebaseUser=mAuth.getCurrentUser();
        boolean emailFlag=firebaseUser.isEmailVerified();

        if(emailFlag){

            Toast.makeText(Signin.this, "SignIn Successful", Toast.LENGTH_SHORT).show();

            // creating or overwriting cache file


            startActivity(new Intent(Signin.this,Mainpage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
            finish();

        }else{

            Toast.makeText(Signin.this, "Verify Your Email", Toast.LENGTH_SHORT).show();
            mAuth.signOut();

        }

    }

    private void signIn() {
        @SuppressLint("RestrictedApi") Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            @SuppressLint("RestrictedApi") Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w("TAG", "Google sign in failed", e);
                // ...
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        mProgress.setMessage("Signing In...");
        mProgress.show();

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        mProgress.dismiss();

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("TAG", "signInWithCredential:success");

                            startActivity(new Intent(Signin.this,Mainpage.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                            finish();

                            //updateUI(user);
                        }
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(Signin.this, e.getMessage(), Toast.LENGTH_LONG).show();

            }
        });

    }



}
