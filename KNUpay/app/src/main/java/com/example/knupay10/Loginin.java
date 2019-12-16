package com.example.knupay10;

import android.os.Bundle;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Loginin extends AppCompatActivity {
    private Button login;
    private Button button5;
    private EditText username, password;
    FirebaseAuth mfire;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginin);
        mfire = FirebaseAuth.getInstance();
        username = (EditText) findViewById(R.id.editText5);
        password = (EditText) findViewById(R.id.editText2);
        login = (Button) findViewById(R.id.button3);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                if(uname.isEmpty())
                {
                    username.setError("Please enter your email");
                    username.requestFocus();
                }
                else if (pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else
                {
                    mfire.signInWithEmailAndPassword(uname,pwd).addOnCompleteListener(Loginin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Loginin.this,"Signing in unsuccessful. Try again",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                FirebaseUser user = mfire.getCurrentUser();
                                if(user != null)
                                {
                                    Toast.makeText(Loginin.this,"Signing in successful",Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(Loginin.this, StartActivity.class));
                                }
                            }
                        }
                    });
                }
            }
        });
        button5 = (Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Loginin.this, Signin.class));
            }
        });
    }
}
