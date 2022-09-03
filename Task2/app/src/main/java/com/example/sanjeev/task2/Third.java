package com.example.sanjeev.task2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Third extends AppCompatActivity {
    TextView t1;
    Button b3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        t1 = (TextView)findViewById(R.id.textView);
        b3 = (Button)findViewById(R.id.button3);

        String res = getIntent().getStringExtra("result");
        t1.setText(res);

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(Third.this, MainActivity.class);
                startActivity(i3);
                finish();
            }
        });
    }
}
