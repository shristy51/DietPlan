package com.example.shristy.dietplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.database.ValueEventListener;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Goal extends AppCompatActivity {
    Button b1,b2,b3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.goal );
      
        b1= (Button) findViewById ( R.id.b1 );
        b2 = (Button) findViewById ( R.id.b2);
        b3= (Button) findViewById ( R.id.b3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(Goal.this, LoseFat.class);
                startActivity(i1);

            }

        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(Goal.this, MaintainWeight.class);
                startActivity(i1);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i1 = new Intent(Goal.this, BuildMuscles.class);
                startActivity(i1);

            }
        });
    }}
