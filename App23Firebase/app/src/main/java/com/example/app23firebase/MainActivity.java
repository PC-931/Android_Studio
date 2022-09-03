package com.example.app23firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button); //login
        b2 = (Button)findViewById(R.id.button2); //register
        e1 = (EditText)findViewById(R.id.editTextTextPersonName); //email
        e2 = (EditText)findViewById(R.id.editTextTextPersonName2); //password
        p1 = (ProgressBar)findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();
        //register button
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
                finish();
            }
        });

        //login button
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();

                if(s1.isEmpty()){
                    e1.setError("Enter your registered Email ID");
                    return;
                }else{
                    if(s2.isEmpty()){
                        e2.setError("Enter your Password");
                        return;
                    }
                }

                p1.setVisibility(View.VISIBLE);

                firebaseAuth.signInWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.INVISIBLE);
                            Intent j = new Intent(MainActivity.this,LogedIn.class);
                            startActivity(j);
                            finish();
                        }else{
                            p1.setVisibility(View.INVISIBLE);
                            Toast.makeText(MainActivity.this, "Invalid Credentials or not Registered!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}