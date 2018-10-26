package com.rohan.hashhacks30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class LoanPropose extends AppCompatActivity {
TextView Emi;
EditText amount;
String loanAmount;

EditText interestRate;
EditText numMonths;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_propose);
        amount=findViewById(R.id.loanamount);
        interestRate=findViewById(R.id.emi);
        numMonths=findViewById(R.id.time);
        Emi=findViewById(R.id.monthlyPay);

    }
}
