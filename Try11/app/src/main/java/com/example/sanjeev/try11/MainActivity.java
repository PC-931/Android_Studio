package com.example.sanjeev.try11;

import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton b;
    WifiManager wm;
    private boolean state = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (ImageButton)findViewById(R.id.imageButton);
        wm = (WifiManager)getSystemService(WIFI_SERVICE);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( state == false){
                    state = true;
                    b.setImageResource(R.drawable.on);
                    wm.setWifiEnabled(true);
                }else{
                    state = false;
                    b.setImageResource(R.drawable.off);
                    wm.setWifiEnabled(false);
                }
            }
        });
    }
}
