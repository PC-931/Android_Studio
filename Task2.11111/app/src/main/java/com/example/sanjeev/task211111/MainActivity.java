package com.example.sanjeev.task211111;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2;
    Button b1,b2,b3;
    TextView t1;
    Float f1,f2;
    String s1, s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText)findViewById(R.id.editText);
        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s1 = e1.getText().toString();
                setContentView(R.layout.second);
                f1 = Float.parseFloat(s1);
                b2 = (Button)findViewById(R.id.button2);
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        e2 = (EditText)findViewById(R.id.editText2);
                        s2 = e2.getText().toString();
                        f2 = Float.parseFloat(s2);
                        setContentView(R.layout.third);
                        t1 = (TextView)findViewById(R.id.textView);
                        Float f3 = f1+f2;
                        String s3 = Float.toString(f3);
                        t1.setText(s3);
                        b3 = (Button)findViewById(R.id.button3);
                        b3.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                //nothing to do

                            }
                        });
                    }
                });
            }
        });

    }
}
