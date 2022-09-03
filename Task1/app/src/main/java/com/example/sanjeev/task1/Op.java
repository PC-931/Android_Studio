package com.example.sanjeev.task1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Op extends AppCompatActivity {
    Button b2;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_op);
        b2 = (Button)findViewById(R.id.button2);
        t1 = (TextView)findViewById(R.id.textView);

        String result = getIntent().getStringExtra("result");

        t1.setText(result);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Op.this, MainActivity.class);
                startActivity(i2);
                finish();
            }
        });
    }
}
