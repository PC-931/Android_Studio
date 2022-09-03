package com.example.app23firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

public class Register extends AppCompatActivity {
    EditText e3, e4;
    Button b3, b4;
    ProgressBar p2;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        b3 = (Button)findViewById(R.id.button3); //register
        b4 = (Button)findViewById(R.id.button4); //back
        e3 = (EditText)findViewById(R.id.editTextTextPersonName3); //email
        e4 = (EditText)findViewById(R.id.editTextTextPersonName4); //password
        p2 = (ProgressBar)findViewById(R.id.progressBar);
        firebaseAuth = FirebaseAuth.getInstance();

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s3, s4;
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();

                if(s3.isEmpty()){
                    e3.setError("Enter email");
                    return;
                }else{
                    if(s4.isEmpty()){
                        e4.setError("Enter password");
                    }
                }

                firebaseAuth.createUserWithEmailAndPassword(s3, s4).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                            Intent a = new Intent(Register.this, MainActivity.class);
                            startActivity(a);
                            finish();
                        }else{
                            Toast.makeText(Register.this, "Registration unsuccessful or Already Successful", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Register.this, MainActivity.class);
                startActivity(k);
                finish();
            }
        });
    }
}