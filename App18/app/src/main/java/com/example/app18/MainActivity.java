package com.example.app18;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.a);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sm.registerListener(this,s,SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float f1= event.values[0];
        float f2= event.values[1];
        float f3= event.values[2];

        int i1 = (int)f1;
        int i2 = (int)f2;
        int i3 = (int)f3;

        if(i1!=0){
            mp.start();
        }else{
            mp.pause();
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}