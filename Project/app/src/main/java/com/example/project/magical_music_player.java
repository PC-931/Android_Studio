package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class magical_music_player extends AppCompatActivity implements SensorEventListener {
    TextView a, b, c;
    Button back;
    MediaPlayer mp;
    Sensor s;
    SensorManager sm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_magical_music_player);


        a = findViewById(R.id.mmp_x);
        b = findViewById(R.id.mmp_y);
        c = findViewById(R.id.mmp_z);


        mp = MediaPlayer.create(this, R.raw.a);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //sm.registerListener(this ,SensorManager.SENSOR_DELAY_NORMAL);

        back = findViewById(R.id.mmp_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent go_back = new Intent(magical_music_player.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float x, y, z;
        x = sensorEvent.values[0];
        y = sensorEvent.values[1];
        z = sensorEvent.values[2];

        int x1 = (int) x;

        if( x1 != 0 ){
            mp.start();
        }else{
            mp.pause();
        }

        a.setText(Float.toString(x));
        b.setText(Float.toString(y));
        c.setText(Float.toString(z));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}