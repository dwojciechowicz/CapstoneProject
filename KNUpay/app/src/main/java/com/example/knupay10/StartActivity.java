package com.example.knupay10;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StartActivity extends AppCompatActivity {
    private Button button2;
    private Button logout;
    private TextView name, balance;
    private FirebaseAuth mfire;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

            name = findViewById(R.id.textView6);
            balance = findViewById(R.id.textView8);
            mfire = FirebaseAuth.getInstance();
            database = FirebaseDatabase.getInstance();
            DatabaseReference dref = database.getReference(mfire.getUid());
            dref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    UserProfile uprof = dataSnapshot.getValue(UserProfile.class);
                    name.setText(uprof.getUsername());
                    balance.setText(uprof.getUserbalance().toString()+" coins");
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            logout =(Button) findViewById(R.id.button7);
            logout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FirebaseAuth.getInstance().signOut();
                    startActivity(new Intent(StartActivity.this, Loginin.class));
                }
            });

            button2 = (Button) findViewById(R.id.button2);
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(StartActivity.this, HistoryActivity.class));
                }
            });
    }

}
