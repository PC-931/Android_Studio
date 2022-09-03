package com.example.sanjeev.try8;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton b;
    BluetoothAdapter ba;
    private boolean blue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (ImageButton) findViewById(R.id.imageButton);
        ba = BluetoothAdapter.getDefaultAdapter();

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( blue == false){
                    blue = true;
                    ba.enable();
                    b.setImageResource(R.drawable.on);
                }else{
                    blue = false;
                    ba.disable();
                    b.setImageResource(R.drawable.off);
                }
            }
        });
    }
}
