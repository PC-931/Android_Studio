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

public class Register extends AppCompatActivity {
    EditText e3, e4, e5;
    Button b3, b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        e3 = (EditText)findViewById(R.id.editText3);
        e4 = (EditText)findViewById(R.id.editText4);
        e5 = (EditText)findViewById(R.id.editText5);
        b3 = (Button)findViewById(R.id.button3);
        b4 = (Button)findViewById(R.id.button4);

        //for HOme
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Register.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        //for registration
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s3, s4, s5;
                s3 = e3.getText().toString();
                s4 = e4.getText().toString();
                s5 = e5.getText().toString();

                if( s3.equals("") || s4.equals("") || s5.equals("")){
                    Toast.makeText(Register.this, "Fill all the details first!!!!", Toast.LENGTH_SHORT).show();
                }
                else{
                    SQLiteDatabase sql = openOrCreateDatabase("pc", MODE_PRIVATE, null);
                    sql.execSQL("create table if not exists student (name varchar, email varchar, password varchar)");
                    //creating a query
                    String s = "select * from student where name='"+s3+"' and email='"+s4+"'";
                    Cursor c = sql.rawQuery(s, null);

                    if(c.getCount()>0){
                        Toast.makeText(Register.this, "User Already Exists!!!", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(Register.this,MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                    else{
                        sql.execSQL("insert into student values ('"+s3+"','"+s4+"','"+s5+"')");
                        Toast.makeText(Register.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                        Intent j = new Intent(Register.this, MainActivity.class);
                        startActivity(j);
                        finish();
                    }
                }
            }
        });
    }
}
