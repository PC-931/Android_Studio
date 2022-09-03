package com.example.app25;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText e1, e2, e3, e4;
    Button b1;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.editTextTextPersonName);
        e2 = (EditText)findViewById(R.id.editTextTextEmailAddress);
        e3 = (EditText)findViewById(R.id.editTextPhone);
        e4 = (EditText)findViewById(R.id.editTextTextPassword);
        e4.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
        b1 = (Button)findViewById(R.id.button3);
        firebaseAuth = FirebaseAuth.getInstance();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseDatabase = FirebaseDatabase.getInstance();
                databaseReference = firebaseDatabase.getReference("data");
                String name, email, phone, password;
                name = e1.getText().toString();
                email = e2.getText().toString();
                phone = e3.getText().toString();
                password = e4.getText().toString();

                if(name.isEmpty()) {
                    e1.setError("Enter name first:");
                    return;
                }else if(email.isEmpty()){
                    e2.setError("Enter email:");
                }else if(phone.isEmpty()){
                    e3.setError("Enter phone number:");
                }else if(password.isEmpty()){
                    e4.setError("Enter password:");
                }

                if((phone.length()!=10) && (password.length()!=10)){
                    Toast.makeText(MainActivity.this, "Invalid number", Toast.LENGTH_SHORT).show();
                }else{
                    user users = new user(name,email,phone,password);
                    databaseReference.child(phone).setValue(users);
                }
            }
        });
    }

}