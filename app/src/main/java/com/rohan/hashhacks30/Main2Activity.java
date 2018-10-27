package com.rohan.hashhacks30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {
    EditText communityUniquename,communitylocation;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        communityUniquename=findViewById(R.id.communityName);
        communitylocation=findViewById(R.id.location);
        //First check uniqueness of id
        //Then Create a new group
        //Create New Balance Sheet
        //Store Community Info
        button=findViewById(R.id.next_button);

        DatabaseHelper databaseHelper=new DatabaseHelper();
        if(databaseHelper.checkifidunique(communityUniquename.getText().toString())){
            button.setEnabled(true);
        }
        else{
            communityUniquename.setText("");
            communityUniquename.setError("This ID already exists");

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Main2Activity.this,MainActivity.class);
                startActivity(i);

            }
        });


    }
}