package com.example.app22firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    ProgressBar p1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        e1 = (EditText)findViewById(R.id.editText);     //name
        e2 = (EditText)findViewById(R.id.editText2);    //password
        p1 = (ProgressBar)findViewById(R.id.progressBar);

        e2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_NUMBER_VARIATION_PASSWORD);

        firebaseAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                if(s1.isEmpty()){
                    e1.setError("Enter email first!!");
                    return;
                }else{
                    if(s2.isEmpty()){
                        e2.setError("Password is empty or less than 6 characters!!");
                    }
                }

                p1.setVisibility(View.VISIBLE);
                firebaseAuth.createUserWithEmailAndPassword(s1,s2).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "You have registered successfully", Toast.LENGTH_SHORT).show();
                            p1.setVisibility(View.INVISIBLE);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Failed to register or already registered with us!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}