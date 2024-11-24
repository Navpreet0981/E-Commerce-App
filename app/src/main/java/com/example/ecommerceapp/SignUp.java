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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    EditText name, email, pass;
    Button signup, login;
    RelativeLayout FbLayout, GoogleLayout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.name_ET);
        email = findViewById(R.id.email_ET);
        pass = findViewById(R.id.pass_ET);
        signup = findViewById(R.id.LogIn_btn);
        login = findViewById(R.id.SignUp_btn);
        FbLayout = findViewById(R.id.FB_Layout);
        GoogleLayout = findViewById(R.id.google_layout);


        signup.setOnClickListener(v -> {
            String Email = email.getText().toString();
            String Pass = pass.getText().toString();
            String Name = name.getText().toString();

            if (Email.isEmpty() || Pass.isEmpty() || Name.isEmpty()) {
                Toast.makeText(SignUp.this, "Please fill all the fields", Toast.LENGTH_SHORT).show();
            } else {
                FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
                firebaseAuth.createUserWithEmailAndPassword(Email, Pass)
                        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                            @Override
                            public void onSuccess(AuthResult authResult) {
                                Toast.makeText(SignUp.this, "Welcome!", Toast.LENGTH_SHORT).show();

                            }
                        }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(SignUp.this, "Error occurred", Toast.LENGTH_SHORT).show();

                            }
                        });
            }
        });
        login.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, LogIn.class);
            startActivity(i);

        });
        GoogleLayout.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, HomePage.class);
            startActivity(i);
        });


    }
}