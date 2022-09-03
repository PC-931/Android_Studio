package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class quiz_menu extends AppCompatActivity {

    Button back, start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        back = findViewById(R.id.quiz_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_back = new Intent(quiz_menu.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

        start = findViewById(R.id.quiz_attempt);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_start_quiz = new Intent(quiz_menu.this, start_quiz.class);
                startActivity(goto_start_quiz);
                finish();
            }
        });
    }
}