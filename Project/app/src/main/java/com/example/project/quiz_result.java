package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class quiz_result extends AppCompatActivity {
    TextView result;
    Button back, restart;
    String final_score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_result);

        final_score = "Your Score is: " + getIntent().getIntExtra("Result", 0) + " / 10";

        result = findViewById(R.id.quiz_resultView);
        result.setText(final_score);

        back = findViewById(R.id.quiz_result_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_back = new Intent(quiz_result.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

        restart = findViewById(R.id.quiz_retake);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retake = new Intent(quiz_result.this, start_quiz.class);
                startActivity(retake);
                finish();
            }
        });
    }
}