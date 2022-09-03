package com.example.sanjeev.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Second extends AppCompatActivity {
    EditText e2;
    Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        e2 = (EditText)findViewById(R.id.editText);
        b2 = (Button)findViewById(R.id.button2);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Second.this, Third.class);
                String s2 = e2.getText().toString();

                Float f1, f2, f3;
                String s1 = getIntent().getStringExtra("valA");
                f2 = Float.parseFloat(s2);
                f3 = Float.parseFloat(s1);
                f1 = f2 + f3;

                String res = Float.toString(f1);

                i2.setClass(Second.this, Third.class);
                i2.putExtra("result",res);
                startActivity(i2);
                finish();
            }
        });
    }
}
