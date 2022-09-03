package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import static android.speech.tts.TextToSpeech.QUEUE_FLUSH;

public class text2speech extends AppCompatActivity {

    EditText text;
    Button back,speak;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text2speech);

        back = findViewById(R.id.tts_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(text2speech.this, special_function.class);
                startActivity(go_back);
                finish();
            }
        });

        text = findViewById(R.id.tts_text);
        speak = findViewById(R.id.tts_speak);
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                tts.setLanguage(Locale.ENGLISH);
                tts.setSpeechRate(1.07f);
            }
        });

        speak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = text.getText().toString();
                tts.speak(s1, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}