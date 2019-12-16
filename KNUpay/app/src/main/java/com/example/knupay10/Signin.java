package com.example.knupay10;

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
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Signin extends AppCompatActivity {
    private Button register;
    private Button button;
    private EditText username, password, emailID, phoneNR;
    FirebaseAuth mfire;
    private String uname, pwd, email, phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        username = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        phoneNR = (EditText) findViewById(R.id.editText3);
        emailID = (EditText) findViewById(R.id.editText4);
        mfire = FirebaseAuth.getInstance();

        register = (Button) findViewById(R.id.button6);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uname = username.getText().toString().trim();
                pwd = password.getText().toString().trim();
                phone = phoneNR.getText().toString().trim();
                email = emailID.getText().toString().trim();
                if(uname.isEmpty())
                {
                    username.setError("Please enter your username");
                    username.requestFocus();
                }
                else  if(pwd.isEmpty())
                {
                    password.setError("Please enter your password");
                    password.requestFocus();
                }
                else  if(phone.isEmpty())
                {
                    phoneNR.setError("Please enter your phone number");
                    phoneNR.requestFocus();
                }
                else  if(email.isEmpty())
                {
                    emailID.setError("Please enter your email");
                    emailID.requestFocus();
                }
                else
                {
                    mfire.createUserWithEmailAndPassword(email,pwd).addOnCompleteListener(Signin.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(Signin.this,"Signing up unsuccessful",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                sendUserData();
                                startActivity(new Intent(Signin.this, StartActivity.class));
                            }
                        }
                    });
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

    public void openActivity() {
        Intent intent = new Intent(this, Loginin.class);
        startActivity(intent);
    }

    private void sendUserData()
    {
        FirebaseDatabase fdata = FirebaseDatabase.getInstance();
        DatabaseReference myref = fdata.getReference(mfire.getUid());
        UserProfile uprof = new UserProfile(uname,email,phone,50);
        myref.setValue(uprof);
    }
}
