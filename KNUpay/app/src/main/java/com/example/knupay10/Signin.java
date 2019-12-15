package com.example.knupay10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Signin extends AppCompatActivity {
    private Button register;
    private Button button;
    private EditText username, password, emailID, phoneNR;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        phoneNR = (EditText) findViewById(R.id.editText3);
        emailID = (EditText) findViewById(R.id.editText4);

        register = (Button) findViewById(R.id.button6);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                String phone = phoneNR.getText().toString();
                String email = emailID.getText().toString();
                if(uname.isEmpty())
                {
                    username.setError("Please enter your username");
                    username.requestFocus();
                }
                else  if(pwd.isEmpty())
                {
                    username.setError("Please enter your password");
                    username.requestFocus();
                }
                else  if(phone.isEmpty())
                {
                    username.setError("Please enter your phone number");
                    username.requestFocus();
                }
                else  if(email.isEmpty())
                {
                    username.setError("Please enter your email");
                    username.requestFocus();
                }
                else
                {
                    openActivity6();
                }
            }
        });

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }
    public void openActivity6() {
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
    public void openActivity() {
        Intent intent = new Intent(this, Loginin.class);
        startActivity(intent);
    }
}
