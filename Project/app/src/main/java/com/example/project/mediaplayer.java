package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class mediaplayer extends AppCompatActivity {

    Button back;
    MediaPlayer mp;
    ImageButton play, pause, ff, bb;
    int incr = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mediaplayer);

        back = findViewById(R.id.mp_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_back = new Intent(mediaplayer.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

        mp = MediaPlayer.create(this, R.raw.a);

        play = findViewById(R.id.mp_play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.start();
            }
        });

        pause = findViewById(R.id.mp_pause);
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mp.pause();
            }
        });

        ff = findViewById(R.id.mp_fast);
        ff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incr = mp.getCurrentPosition() + 10000;
                mp.getTimestamp();
                mp.seekTo(incr);
            }
        });

        bb= findViewById(R.id.mp_bb);
        bb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                incr = mp.getCurrentPosition() - 10000;
                mp.seekTo(incr);
            }
        });

//        mp.getDuration();
//        mp.getTimestamp();
//        mp.stop();
    }
}