package com.example.knupay10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TransferActivity extends AppCompatActivity {
    private Button button, transfer;
    private EditText email, amount;
    private FirebaseAuth mfire;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);
        email = (EditText) findViewById(R.id.editText6);
        amount = (EditText) findViewById(R.id.editText7);
        mfire = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        final DatabaseReference dref = database.getReference(mfire.getUid());

        transfer = (Button) findViewById(R.id.button8);
        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = email.getText().toString().trim();
                String money = amount.getText().toString().trim();
                if(mail.isEmpty())
                {
                    email.setError("Please enter email address of the receiver");
                    email.requestFocus();
                }
                else if(money.isEmpty())
                {
                    amount.setError("Please enter amount of the transfer");
                    amount.requestFocus();
                }
                else
                {
                    final Integer tosend = Integer.valueOf(Integer.parseInt(money));
                    //MAKE TRANSFER
                    Toast.makeText(TransferActivity.this,"This option is not available yet",Toast.LENGTH_SHORT).show();
                    /*final DatabaseReference destination = database.getReference("knupay-92fbd/b6NywuYmbQQzyj2J3FYsz4u8HVf2");
                    dref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            UserProfile uprof = dataSnapshot.getValue(UserProfile.class);
                            if(tosend>uprof.getUserbalance()|| tosend<=0)
                                Toast.makeText(TransferActivity.this,"Wrong amount",Toast.LENGTH_SHORT).show();
                            else
                            {
                                Integer a = uprof.getUserbalance()-tosend;
                                uprof.setUserbalance(a);
                                dref.setValue(uprof);
                                destination.addValueEventListener(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(@NonNull DataSnapshot dataSnapshot1) {
                                        UserProfile uprof1 = dataSnapshot1.getValue(UserProfile.class);
                                        Integer b = uprof1.getUserbalance()+tosend;
                                        uprof1.setUserbalance(b);
                                        destination.setValue(uprof1);
                                    }
                                    @Override
                                    public void onCancelled(@NonNull DatabaseError databaseError) {}
                                });
                                openActivity();
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {}
                    });*/
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
        Intent intent = new Intent(this, StartActivity.class);
        startActivity(intent);
    }
}