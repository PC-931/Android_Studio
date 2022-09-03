package com.example.app19;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;
    private boolean flash = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager cm = (CameraManager)getSystemService(CAMERA_SERVICE);
                try{
                    String id = cm.getCameraIdList()[0];
                    cm.setTorchMode(id, true);
                    flash = true;
                }
                catch( CameraAccessException e){
                    Toast.makeText(MainActivity.this, "exception occur!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager cm = (CameraManager)getSystemService(CAMERA_SERVICE);
                try{
                    String id = cm.getCameraIdList()[0];
                    cm.setTorchMode(id, false);
                    flash = false;
                }
                catch( CameraAccessException e){
                    Toast.makeText(MainActivity.this, "exception occur!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}