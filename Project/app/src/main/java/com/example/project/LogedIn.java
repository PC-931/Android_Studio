package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LogedIn extends AppCompatActivity {
    Button back, mp, calc, camera, sf, quiz, mmp, video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loged_in);

        back = findViewById(R.id.button_back);
        back.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent go_back =  new Intent(LogedIn.this, MainActivity.class);
                 startActivity(go_back);
                 finish();
             }
        });

        mp = findViewById(R.id.button_mediaPlayer);
        mp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_mp = new Intent(LogedIn.this, mediaplayer.class);
                startActivity(goto_mp);
                finish();
            }
        });

        calc = findViewById(R.id.button_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_calc = new Intent(LogedIn.this, calculator.class);
                startActivity(goto_calc);
                finish();
            }
        });

        camera = findViewById(R.id.button_camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_camera = new Intent(LogedIn.this, Camera.class);
                startActivity(goto_camera);
                finish();
            }
        });

        sf = findViewById(R.id.button_special);
        sf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_sf = new Intent(LogedIn.this, special_function.class);
                startActivity(goto_sf);
                finish();
            }
        });

        video = findViewById(R.id.button_video);
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_video = new Intent(LogedIn.this, Video.class);
                startActivity(goto_video);
                finish();
            }
        });

        mmp = findViewById(R.id.button_magicPlayer);
        mmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_mmp = new Intent(LogedIn.this, magical_music_player.class);
                startActivity(goto_mmp);
                finish();
            }
        });

        quiz = findViewById(R.id.button_quiz);
        quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goto_quiz = new Intent(LogedIn.this, quiz_menu.class);
                startActivity(goto_quiz);
                finish();
            }
        });
    }
}