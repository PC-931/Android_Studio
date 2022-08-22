package com.example.sanjeev.app8;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton ib;
    BluetoothAdapter ba;
    private boolean blue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ib = (ImageButton)findViewById(R.id.imageButton);
        ba = BluetoothAdapter.getDefaultAdapter();

        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if( blue == false){
                    blue = true;
                    ba.enable();
                    ib.setImageResource(R.drawable.on);
                }
                else {
                    blue = false;
                    ba.disable();
                    ib.setImageResource(R.drawable.off);
                }
            }
        });
    }
}
