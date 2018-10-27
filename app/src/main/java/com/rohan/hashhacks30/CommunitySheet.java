//package com.rohan.hashhacks30;
//
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.Map;
//
//public class CommunitySheet extends AppCompatActivity {
//    TextView NoOfPeopleContributed,TotalAmountCollected,PeopleLeftToContri,peoplecontr2;
//    Spinner Months;
//    //Button button;
//    String months[]={"Jan","Feb","Mar","Apr","May","Jun","Aug","Sep","Oct","Nov","Dec"};
//    public int getcurrentmonth(){
//        return -1;
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        String balancesheetid="";
//        //get Balancesheetid from intent
//        setContentView(R.layout.activity_community_sheet);
//        DatabaseHelper databaseHelper=new DatabaseHelper();
//        Months=findViewById(R.id.month_spinner);
//        //button=findViewById(R.id.contributton);
//        NoOfPeopleContributed=findViewById(R.id.no_of_people_contributed);
//        TotalAmountCollected=findViewById(R.id.no_of_people_contributed1);
//        PeopleLeftToContri=findViewById(R.id.no_of_people_contributed2);
//        peoplecontr2=findViewById(R.id.peoplecontri2);
//
//        ArrayList arrayList=new ArrayList(Arrays.asList(months));
//        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_dropdown_item_1line,arrayList.);
//        arrayAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
//        Months.setAdapter(arrayAdapter);
//
//        if(getcurrentmonth()<Months.getSelectedItemPosition()+1){
//            Map<String,String> arr=databaseHelper.getMonthdata(months[Months.getSelectedItemPosition()],balancesheetid);
//            NoOfPeopleContributed.setText(arr.get("NOP_CONTRI"));
//            TotalAmountCollected.setText(arr.get("TOTALAMOUNT"));
//            PeopleLeftToContri.setText(arr.get("PEOPLELEFTTOCONTRI"));
//
//            button.setEnabled(false);
//            //Do when Accessing future
//        }
//        else if(getcurrentmonth()==Months.getSelectedItemPosition()+1){
//
//            Map<String,String> arr=databaseHelper.getMonthdata(months[Months.getSelectedItemPosition()],balancesheetid);
//            NoOfPeopleContributed.setText(arr.get("NOP_CONTRI"));
//            TotalAmountCollected.setText(arr.get("TOTALAMOUNT"));
//            PeopleLeftToContri.setText(arr.get("PEOPLELEFTTOCONTRI"));
//
//        }
//        else{
//            peoplecontr2.setText("Last Auctioned %");
//            Map<String,String> arr=databaseHelper.getMonthdata(months[Months.getSelectedItemPosition()],balancesheetid);
//            NoOfPeopleContributed.setText(arr.get("NOP_CONTRI"));
//            TotalAmountCollected.setText(arr.get("TOTALAMOUNT"));
//            PeopleLeftToContri.setText(arr.get("MAXBID"));
//            button.setEnabled(false);
//        }
//
//
//
//    }
//}
