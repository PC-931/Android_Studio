package com.example.task3;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    WifiManager wm;
    BluetoothAdapter ba;
    SensorManager sm;
    Sensor s;
    TextView t1, t2, t3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mp = MediaPlayer.create(this, R.raw.a);
        wm = (WifiManager)getSystemService(WIFI_SERVICE);
        ba = BluetoothAdapter.getDefaultAdapter();
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, s, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        float x, y, z;
        x = event.values[0];
        y = event.values[1];
        z = event.values[2];

        int x1 = (int)x;
        int y1 = (int)x;
        int z1 = (int)x;

        String s1, s2, s3;

        s1 = Integer.toString(x1);
        s2 = Integer.toString(y1);
        s3 = Integer.toString(z1);

        t1.setText(s1);
        t2.setText(s2);
        t3.setText(s3);

        if( x1!= 0 && y1!=0 && z1!=0 ){
            mp.start();
            ba.enable();
            wm.setWifiEnabled(true);
        }else{
            mp.pause();
            ba.disable();
            wm.setWifiEnabled(false);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        //nothing to do
    }
}