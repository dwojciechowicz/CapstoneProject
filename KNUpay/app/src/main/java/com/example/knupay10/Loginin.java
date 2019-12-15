package com.example.knupay10;



import android.os.Bundle;
import android.content.Intent;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Loginin extends AppCompatActivity {
    private Button login;
    private Button button5;
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);
        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                if(uname.isEmpty())
                {
                    username.setError("Please enter your username");
                    username.requestFocus();
                }
                else if (pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else if (!(uname.isEmpty()|| pwd.isEmpty() ) )
                {
                    Intent intent = new Intent( Loginin.this, StartActivity.class);
                    startActivity(intent);
                }
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity5();
            }
        });
    }
    public void openActivity5() {
        Intent intent = new Intent(this, Signin.class);
        startActivity(intent);
    }
}
