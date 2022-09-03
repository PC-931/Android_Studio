package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class special_function extends AppCompatActivity {

    Button back, browser, tts;
    ImageButton ib_bluetooth, ib_flash;
    BluetoothAdapter ba;
    private boolean blue=false, flash=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_function);

        back = findViewById(R.id.sf_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent go_back = new Intent(special_function.this, LogedIn.class);
                startActivity(go_back);
                finish();
            }
        });

        ib_bluetooth = findViewById(R.id.sf_bluetooth);
        ba = BluetoothAdapter.getDefaultAdapter();
        ib_bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( blue==false ){
                    blue=true;
                    ba.enable();
                    ib_bluetooth.setImageResource(R.drawable.bluetooth_on);
                }else{
                    blue=false;
                    ba.disable();
                    ib_bluetooth.setImageResource(R.drawable.bluetooth_off);
                }
            }
        });

        browser = findViewById(R.id.sf_browser);
        browser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_browser = new Intent(special_function.this, browser.class);
                startActivity(goto_browser);
                finish();
            }
        });

        ib_flash = findViewById(R.id.sf_torch);
        ib_flash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager cm = (CameraManager)getSystemService(CAMERA_SERVICE);
                if(flash==false){
                    try{
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, true);
                        flash = true;
                        ib_flash.setImageResource(R.drawable.flash_on);
                    }catch ( CameraAccessException e ){
                        Toast.makeText(special_function.this, "Some Error Occurred!!!", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    try{
                        String id = cm.getCameraIdList()[0];
                        cm.setTorchMode(id, false);
                        flash = false;
                        ib_flash.setImageResource(R.drawable.flash_off);
                    }catch ( CameraAccessException e ){
                        Toast.makeText(special_function.this, "Some Error Occurred!!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        tts = findViewById(R.id.sf_tts);
        tts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_tts = new Intent(special_function.this, text2speech.class);
                startActivity(goto_tts);
                finish();
            }
        });
    }
}