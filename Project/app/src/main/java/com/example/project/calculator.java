package com.example.project;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class calculator extends AppCompatActivity {
    Button add, sub, mul, div, back, reset;
    TextView result;
    EditText e1, e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        back = findViewById(R.id.button_calc_back);
        back.setOnClickListener(v -> {
            Intent i = new Intent(calculator.this, LogedIn.class);
            startActivity(i);
            finish();
        });

        e1 = findViewById(R.id.calc_numA);
        e2 = findViewById(R.id.calc_numB);
        result = findViewById(R.id.calc_result);

        e1.setText("0");
        e2.setText("0");

        add = findViewById(R.id.calc_add);
        add.setOnClickListener(v -> {
            String s1, s2, s3;

            s1=e1.getText().toString();
            s2=e2.getText().toString();


            if( s1.isEmpty() ){
                e1.setError("Please enter value first");
            }

            if( s2.isEmpty()){
                e2.setError("Please enter value first");
            }
            float f1, f2, f3;

            f1 = Float.parseFloat(s1);
            f2 = Float.parseFloat(s2);
            f3 = f1+f2;
            s3=Float.toString(f3);

            result.setText(s3);
        });

        sub = findViewById(R.id.calc_sub);
        sub.setOnClickListener(v -> {
            String s1, s2, s3;

            s1=e1.getText().toString();
            s2=e2.getText().toString();

            if( s1.isEmpty() || s2.isEmpty() ){
                e1.setError("Please provide value first");
            }

            if( s2.isEmpty()){
                e2.setError("Please enter value first");
            }

            float f1, f2, f3;
            f1=Float.parseFloat(s1);
            f2=Float.parseFloat(s2);
            f3 = f1-f2;
            s3=Float.toString(f3);

            result.setText(s3);
        });

        mul = findViewById(R.id.calc_mul);
        mul.setOnClickListener(v -> {
            String s1, s2, s3;

            s1=e1.getText().toString();
            s2=e2.getText().toString();

            if( s1.isEmpty() || s2.isEmpty() ){
                e1.setError("Please provide value first");
            }

            if( s2.isEmpty()){
                e2.setError("Please enter value first");
            }

            float f1, f2, f3;
            f1=Float.parseFloat(s1);
            f2=Float.parseFloat(s2);
            f3 = f1*f2;
            s3=Float.toString(f3);

            result.setText(s3);
        });

        div = findViewById(R.id.calc_div);
        div.setOnClickListener(v -> {
            String s1, s2, s3;

            s1=e1.getText().toString();
            s2=e2.getText().toString();

            if( s1.isEmpty() || s2.isEmpty() ){
                e1.setError("Please provide value first");
            }

            if( s2.isEmpty()){
                e2.setError("Please enter value first");
            }

            float f1, f2, f3;
            f1=Float.parseFloat(s1);
            f2=Float.parseFloat(s2);
            f3 = f1/f2;
            s3=Float.toString(f3);

            result.setText(s3);
        });

        reset = findViewById(R.id.calc_reset);
        reset.setOnClickListener(v -> {
            e1.setText("0");
            e2.setText("0");
            result.setText("0");
        });
    }
}