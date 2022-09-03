package com.example.sanjeev.app15;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText)findViewById(R.id.editText);
        e2 = (EditText)findViewById(R.id.editText2);
        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button2);

        //for registration
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
                finish();
            }
        });

        //for LOGIN
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = e1.getText().toString();
                String s2 = e2.getText().toString();

                if( s1.equals("") || s2.equals("")){
                    Toast.makeText(MainActivity.this, "Enter the details first!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql = openOrCreateDatabase("pc",MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar, email varchar, password varchar)");
                    String query = "select * from student where name='"+s1+"' and email='"+s2+"' ";
                    Cursor c = sql.rawQuery(query, null);
                    if(c.getCount()>0){
                        Toast.makeText(MainActivity.this, "Login Successful!!!", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent( MainActivity.this, Login.class);
                        startActivity(j);
                        finish();
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login failed, wrong name and email ID!!!", Toast.LENGTH_SHORT).show();
                    }
                    c.close();
                }
            }
        });
    }
}
