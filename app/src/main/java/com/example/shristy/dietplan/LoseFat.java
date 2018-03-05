package com.example.shristy.dietplan;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

/**
 * Created by shristy on 5/3/18.
 */

public class LoseFat extends AppCompatActivity {
    private TextView e1,e2;
    private FirebaseAuth auth;
    private Firebase mRef;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mRef=new Firebase("https://dietplan-4b03f.firebaseio.com/Users/Uid");
        setContentView(R.layout.losefat);
        e1 = (TextView) findViewById(R.id.e1);
        e2 = (TextView) findViewById(R.id.e2);

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
                intake=cal1-500;
                String intake1=String.valueOf(intake);
                e2.setText(intake1);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }}