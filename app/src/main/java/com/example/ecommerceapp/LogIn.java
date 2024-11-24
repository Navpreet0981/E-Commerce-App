package com.example.ecommerceapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LogIn extends AppCompatActivity {

    EditText Email, Pass;
    Button LogIn, SignUp;
    RelativeLayout Google;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_log_in);
        Email = findViewById(R.id.email_ET);
        Pass = findViewById(R.id.pass_ET);
        LogIn = findViewById(R.id.LogIn_btn);
        SignUp = findViewById(R.id.SignUp_btn);
        Google = findViewById(R.id.google_layout);

        LogIn.setOnClickListener(v -> {
            String mail = Email.getText().toString();
            String pass = Pass.getText().toString();

            if (mail.isEmpty() || pass.isEmpty()) {
                Toast.makeText(LogIn.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.signInWithEmailAndPassword(mail, pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(LogIn.this, "Welcome Back!", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LogIn.this, "Try Again", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });

        SignUp.setOnClickListener(v -> {
            Intent i = new Intent(LogIn.this, SignUp.class);
            startActivity(i);
        });

        Google.setOnClickListener(v -> {
            Intent i = new Intent(LogIn.this, HomePage.class);
            startActivity(i);
        });

    }
}