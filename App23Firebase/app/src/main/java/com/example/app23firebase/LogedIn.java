package com.example.app23firebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class LogedIn extends AppCompatActivity {
    Button b1,b2;
    Vibrator v1;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_in);
        b1 = (Button)findViewById(R.id.button5);
        b2 = (Button)findViewById(R.id.button6);
        v1 = (Vibrator)getSystemService(VIBRATOR_SERVICE);
        firebaseAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT > 25){
                    v1.vibrate(2000);
                }else{
                    v1.vibrate(2000);
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent m = new Intent(LogedIn.this, MainActivity.class);
                startActivity(m);
                finish();
            }
        });
    }
}