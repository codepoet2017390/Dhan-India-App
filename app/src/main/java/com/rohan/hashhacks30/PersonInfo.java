package com.rohan.hashhacks30;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Map;

public class PersonInfo extends AppCompatActivity {
TextView name;
TextView communityName;
TextView investedAmount;
TextView earning;
String naam;
Map<String,String> m;
SharedPreferences pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);
        name=findViewById(R.id.nameTextView);
        communityName=findViewById(R.id.communityName);
        investedAmount=findViewById(R.id.totalInvested);
        earning=findViewById(R.id.earnedamount);
        DatabaseHelper databaseHelper = new DatabaseHelper();
        pref=getPreferences(MODE_PRIVATE);
        String email=pref.getString("firebasekey","vinamrabathwal99@gmail.com");
        m=databaseHelper.getuserinfo(email);
        name.setText(m.get("NAME"));
//        communityName.setText(m.);
        investedAmount.setText(m.get("TOTALMONEY"));
        int z=Integer.parseInt(m.get("TOTALMONEY"));
        int x=Integer.parseInt(m.get("INTEREST"));
        int y= z+(z*x)/100;
        earning.setText(y);
    }
}
