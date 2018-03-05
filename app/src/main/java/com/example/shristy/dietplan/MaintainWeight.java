package com.example.shristy.dietplan;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Map;

public class MaintainWeight extends AppCompatActivity {

    private TextView e1,e2;
    private FirebaseAuth auth;
    private Firebase mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get Firebase auth instance
        auth = FirebaseAuth.getInstance();
        FirebaseUser currentFirebaseUser = auth.getCurrentUser() ;
        final String Uid=currentFirebaseUser.getUid();

        mref=new Firebase("https://dietplan-4b03f.firebaseio.com/Users/Uid");

        // set the view now
        setContentView(R.layout.maintainweight);
        e1 = (TextView) findViewById(R.id.e1);
        e2 = (TextView) findViewById(R.id.e2);
        mref.addValueEventListener(new ValueEventListener() {
                                       @Override
                                       public void onDataChange(DataSnapshot dataSnapshot) {
                                           Map<String,String> map =dataSnapshot.getValue(Map.class);
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
                                           intake=cal1;
                                           String intake1=String.valueOf(intake);
                                           e2.setText(intake1);
                                       }

                                       @Override
                                       public void onCancelled(FirebaseError firebaseError) {

                                       }
                                   }

        );


    }}