package com.rohan.hashhacks30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Map;

public class SanctionLoan extends AppCompatActivity {
    TextView name;
    TextView amount;
    Button accept;
    SharedPreferences sharedPref;
    Button decline;
    int amt;
    Map<String,String> m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanction_loan);
        final DatabaseHelper db=new DatabaseHelper();
        name=findViewById(R.id.textView3);
        amount=findViewById(R.id.amount);
        accept=findViewById(R.id.sanctionButton);
        decline=findViewById(R.id.declineButton);
        amount.setText(LoanPropose.loanAmount);
        sharedPref = getSharedPreferences("logindetails",MODE_PRIVATE);
        final String UserId = sharedPref.getString("firebasekey", "");
        name.setText(UserId);
        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m=db.getuserinfo(UserId);
                amt=Integer.parseInt(m.get("TOTALMONEY"));
                amt=amt-LoanPropose.loanAmount;
                //db.putuserinfo(Integer.toString(LoanPropose.total),Integer.toString(amt),UserId,Integer.toString(LoanPropose.rate),UserId);
            }
        });

        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message=UserId+" your loan has been declined by the head ";
                Intent intent=new Intent(SanctionLoan.this,MainChatActivity.class);
                intent.putExtra("cancelled",message);
                finish();
                startActivity(intent);
            }

        });

    }
}