package com.example.project;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import java.net.URI;

public class Video extends AppCompatActivity {

    VideoView v1;
    Button capture, back;
    Uri uri;
    MediaController m1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        v1 = findViewById(R.id.video_videoView);
        m1 = new MediaController(this);

        back = findViewById(R.id.video_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_back = new Intent(Video.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

        capture = findViewById(R.id.video_record);
        capture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent record = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                startActivityForResult(record, 0);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        v1.setVideoURI(uri);
        m1.setAnchorView(v1);
        v1.start();
    }
}