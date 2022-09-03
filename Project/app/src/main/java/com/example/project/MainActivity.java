package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //login
    Button login, signup;
    EditText log_id, log_password;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.logIn);
        signup = findViewById(R.id.signUp);
        log_id = findViewById(R.id.LogName);
        log_password = findViewById(R.id.LogPassword);
        
        firebaseAuth = FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2;
                s1 = log_id.getText().toString();
                s2 = log_password.getText().toString();
                
                if( s1.isEmpty() ){
                    log_id.setError("Enter Email Id first!!!");
                    return;
                }
                
                if( s2.isEmpty() ){
                    log_password.setError("Enter your password first!!!");
                    return;
                }
                
                firebaseAuth.signInWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent login = new Intent(MainActivity.this, LogedIn.class);
                            startActivity(login);
                            finish();
                        }else{
                            Toast.makeText(MainActivity.this, "Something went wrong or Incorrect Password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_sign = new Intent(MainActivity.this, signUp.class);
                startActivity(goto_sign);
                finish();
            }
        });
    }
}