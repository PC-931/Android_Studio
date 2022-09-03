package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1,e2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        e2 = (EditText)findViewById(R.id.editTextTextPersonName2);
        b1 = (Button)findViewById(R.id.button);
        t1 = (TextView)findViewById(R.id.textView);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1,s2,s3;
                s1  = e1.getText().toString();
                s2 = e2.getText().toString();

                Float f1,f2,f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);

                f3 = f1+f2;

                s3 = Float.toString(f3);

                t1.setText(s3);
            }
        });
    }
}