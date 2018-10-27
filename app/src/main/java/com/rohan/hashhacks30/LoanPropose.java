package com.rohan.hashhacks30;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoanPropose extends AppCompatActivity {
TextView Emi;
EditText amount;
String reasonx;
EditText reason2;
public static int loanAmount;
public static int rate;
int timeMon;
public static int total;
Button mButton;
EditText interestRate;
EditText numMonths;
String message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loan_propose);
        amount=findViewById(R.id.loanamount);
        interestRate=findViewById(R.id.emi);
        reason2=findViewById(R.id.reason);
        reasonx=reason2.getText().toString();
        numMonths=findViewById(R.id.time);
        Emi=findViewById(R.id.monthlyPay);
        mButton=findViewById(R.id.button3);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reasonx=reason2.getText().toString();
               message="I propose to claim a loan from the community of amount "+loanAmount
                        +" at an interest rate of "+rate+"%"+" due to the reason : "+reasonx+" and i will return this amount" +
                        " within "+timeMon+" Months by any means and methods";

                Intent intent=new Intent(LoanPropose.this,MainChatActivity.class);
                intent.putExtra("message",message);
                finish();
                startActivity(intent);
            }
        });
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
