package com.example.shristy.dietplan;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class First extends AppCompatActivity {

    private EditText e1,e2,e3;
    private FirebaseAuth auth;
    private RadioGroup r,r9;
    private RadioButton r1,r2,r3,r4,r5;
    private Button bf,b4;
    private Firebase mRootRef,Ui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = auth.getCurrentUser() ;
        final String Uid=currentFirebaseUser.getUid();

        mRootRef=new Firebase("https://dietplan-4b03f.firebaseio.com/Users");

        // set the view now
        setContentView(R.layout.first);
        e1 = (EditText) findViewById(R.id.e1);
        e2 = (EditText) findViewById(R.id.e2);
        e3 = (EditText) findViewById(R.id.e3);
        b4 = (Button) findViewById(R.id.b4);


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String value1 =e1.getText().toString();
                String value2 =e2.getText().toString();
                String value3 =e3.getText().toString();
                RadioGroup r = (RadioGroup) findViewById(R.id.rg1);
                final String value =
                        ((RadioButton)findViewById(r.getCheckedRadioButtonId())).getText().toString();
                RadioGroup r9 = (RadioGroup) findViewById(R.id.rg2);
                final String value4 =
                        ((RadioButton)findViewById(r9.getCheckedRadioButtonId())).getText().toString();

                Firebase ChildRef=mRootRef.child(Uid);
                Ui=new Firebase("https://dietplan-4b03f.firebaseio.com/Users/Uid");
                Firebase ChildRef1=Ui.child("Height");
                ChildRef1.setValue(value1);
                Firebase ChildRef2=Ui.child("Weight");
                ChildRef2.setValue(value2);
                Firebase ChildRef3=Ui.child("Age");
                ChildRef3.setValue(value3);
                Firebase ChildRef4=Ui.child("Gender");
                ChildRef4.setValue(value);
                Firebase ChildRef5=Ui.child("Activity Level");
                ChildRef5.setValue(value4);
                Intent i = new Intent(First.this, Goal.class);
                startActivity(i);

            }
        });
    }}