package com.example.app24;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Otp extends AppCompatActivity {

    EditText e1;
    Button b1;
    FirebaseAuth firebaseAuth;
    String phone, otpID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        e1 = (EditText)findViewById(R.id.editText2);
        b1 = (Button)findViewById(R.id.button2);

        phone = getIntent().getStringExtra("mobile").toString();

        firebaseAuth = FirebaseAuth.getInstance();
        genOTP();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1= e1.getText().toString();

                if(s1.isEmpty()){
                    Toast.makeText(Otp.this, "Enter OTP first!!", Toast.LENGTH_SHORT).show();
                }else{
                    if(s1.length()!=6){
                        Toast.makeText(Otp.this, "Invalid OTP", Toast.LENGTH_SHORT).show();
                    }else{
                        PhoneAuthCredential credentials = PhoneAuthProvider.getCredential(otpID, s1);
                        signInWithPhoneAuthCredential(credentials);
                    }
                }
            }
        });
    }
    private void genOTP(){
        PhoneAuthProvider.getInstance().verifyPhoneNumber(phone, 60, TimeUnit.SECONDS, this, new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onCodeSent(@NonNull @org.jetbrains.annotations.NotNull String s, @NonNull @org.jetbrains.annotations.NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                super.onCodeSent(s, forceResendingToken);
                otpID = s;
            }

            @Override
            public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential) {
                signInWithPhoneAuthCredential(phoneAuthCredential);
            }

            @Override
            public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e) {
                Toast.makeText(Otp.this, "OTP mismatch", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Toast.makeText(Otp.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Otp.this, LogedIn.class);
                    startActivity(i);
                    finish();
                }else {
                    Toast.makeText(Otp.this, "Authentication Failed", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}