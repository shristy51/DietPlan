package com.example.shristy.dietplan;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.auth.FirebaseUser;

import java.util.Map;

/**
 * Created by shristy on 5/3/18.
 */

public class BuildMuscles extends AppCompatActivity {
    private TextView e1,e2,t11,t9;
    private Button btnBack,bcl;
    private FirebaseAuth auth;
    private Firebase mRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = auth.getCurrentUser() ;
        final String Uid=currentFirebaseUser.getUid();

        mRef=new Firebase("https://dietplan-4b03f.firebaseio.com/Users"+ Uid);
        setContentView(R.layout.buildmuscles);
        e1 = (TextView) findViewById(R.id.e1);
        t11 = (TextView) findViewById(R.id.t11);
        t9= (TextView) findViewById(R.id.t9);
        btnBack = (Button) findViewById(R.id.btn_back);
        bcl = (Button) findViewById(R.id.bcl);
        e2 = (TextView) findViewById(R.id.e2);
        bcl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuildMuscles.this, Info3.class));
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mRef.addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(com.firebase.client.DataSnapshot dataSnapshot) {
                Map<String, String> map =dataSnapshot.getValue(Map.class);
                String Height=map.get("Height");
                String Weight=map.get("Weight");
                String Age=map.get("Age");
                String Gender=map.get("Gender");
                String Activity=map.get("Activity Level");
                double h = Double.parseDouble(Height);
                double w = Double.parseDouble(Weight);
                int a = Integer.parseInt(Age);
                double s= (h*h)/10000;
                double bmi=w/s;
                if(bmi<20)
                {
                    t11.setText("So,You are UnderWeight!!");
                }
                else if(bmi<25 && bmi>20)
                {t11.setText("So,You are Healthy!!");}
                else if(bmi<30 && bmi>25)
                {t11.setText("So,You are Overweight!!");}
                else{t11.setText("So,You are Obese!!");}

                t9.setText("You want to Maintain weight");
                double bmr,cal1,intake;
                String bmi1=String.valueOf(bmi);
                e1.setText(bmi1);
                if(Gender=="Male"){
                    bmr=(10*w)+(6.25*h)-(5*a)+5;
                }
                else {
                    bmr=(10*w)+(6.25*h)-(5*a)-161;
                }
                if(Activity=="Low")
                {
                    cal1=1.375*bmr;
                }
                else if(Activity=="Moderate")
                {
                    cal1=1.55*bmr;
                }
                else {
                    cal1=1.9*bmr;
                }
                intake=cal1+500;
                String intake1=String.valueOf(intake);
                e2.setText(intake1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }}