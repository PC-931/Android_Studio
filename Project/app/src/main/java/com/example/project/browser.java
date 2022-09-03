package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class browser extends AppCompatActivity {

    Button back, go;
    EditText url;
    WebView w1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);

        back = findViewById(R.id.browser_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(browser.this, special_function.class);
                startActivity(go_back);
                finish();
            }
        });

        go = findViewById(R.id.browser_go);
        url = findViewById(R.id.browser_url);
        w1 = findViewById(R.id.browser_webView);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = url.getText().toString();
                w1.loadUrl(s1);
            }
        });
    }
}