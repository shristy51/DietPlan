package com.example.shristy.dietplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.firebase.auth.FirebaseAuth;

public class First extends AppCompatActivity {

    private EditText e1,e2,e3;
    private FirebaseAuth auth;
    private RadioGroup r;
    private RadioButton r1,r2,r3,r4,r5;
    private Button bf,b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();

        // set the view now
        setContentView(R.layout.first);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        bf = (Button) findViewById(R.id.bf);
        b4 = (Button) findViewById(R.id.b4);
        bf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(First.this, First.class);
                startActivity(i);

            }

        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(First.this, Goal.class);
                startActivity(i);

            }
        });
    }}