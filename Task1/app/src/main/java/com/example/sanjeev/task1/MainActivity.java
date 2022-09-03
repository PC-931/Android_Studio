package com.example.sanjeev.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b1;
    EditText e1, e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        b1 = (Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1, s2, s3;
                s1 = e1.getText().toString();
                s2 = e2.getText().toString();


                Float f1, f2, f3;
                f1 = Float.parseFloat(s1);
                f2 = Float.parseFloat(s2);

                f3 = f1 + f2;

                s3 = Float.toString(f3);
                Intent i1 = new Intent(MainActivity.this, Op.class);
                i1.setClass(MainActivity.this, Op.class);
                i1.putExtra("result",s3);

                startActivity(i1);
                finish();
            }
        });
    }
}
