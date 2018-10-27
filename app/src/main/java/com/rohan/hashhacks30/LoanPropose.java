package com.rohan.hashhacks30;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class LoanPropose extends AppCompatActivity {
TextView Emi;
EditText amount;
int loanAmount;
int rate;
int timeMon;
int total;
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
//        loanAmount=Integer.parseInt(amount.getText().toString());
//        rate=Integer.parseInt(interestRate.getText().toString());
//        timeMon=Integer.parseInt(numMonths.getText().toString());
//        total=loanAmount+loanAmount*rate/100;
//        total=total/timeMon;
//        Emi.setText("Your Emi is -"+total);
      numMonths.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
              if(s.length()!=0)
              {
        loanAmount=Integer.parseInt(amount.getText().toString());
        rate=Integer.parseInt(interestRate.getText().toString());
        timeMon=Integer.parseInt(numMonths.getText().toString());
        total=loanAmount+loanAmount*rate/100;
        total=total/timeMon;
        Emi.setText("Your Emi is - "+total);
              }
            }
        });

    }


}
