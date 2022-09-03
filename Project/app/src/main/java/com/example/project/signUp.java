package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class signUp extends AppCompatActivity {
    Button b1, b2;
    EditText e1, e2;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        e1 = findViewById(R.id.sign_Email);
        e2 = findViewById(R.id.sign_password);
        firebaseAuth = FirebaseAuth.getInstance();

        b1 = findViewById(R.id.sign_back);
        b2 = findViewById(R.id.sign_signup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(signUp.this, MainActivity.class);
                startActivity(go_back);
                finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1, s2;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();
                
                if( s1.isEmpty() ){
                    e1.setError("Enter Email First!!!");
                    return;
                }
                if(s2.length() < 4){
                    e2.setError("Please enter password greater than 4!!");
                    return;
                }
                if(!validateEmail(s1)){
                    e1.setError("Invalid email!!");
                    return;
                }
                
                firebaseAuth.createUserWithEmailAndPassword(s1, s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if( task.isSuccessful()){
                            Toast.makeText(signUp.this, "Registration Successful!!!", Toast.LENGTH_SHORT).show();
                            Intent goto_main = new Intent(signUp.this, MainActivity.class);
                            startActivity(goto_main);
                            finish();
                        }else{
                            Toast.makeText(signUp.this, "Some Error occured or user already registered!!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
    private boolean validateEmail(String data){
        Pattern emailPattern = Pattern.compile(".+@.+\\.[a-z]+");
        Matcher emailMatcher = emailPattern.matcher(data);
        return emailMatcher.matches();
    }
}