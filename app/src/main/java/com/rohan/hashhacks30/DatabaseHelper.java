package com.rohan.hashhacks30;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;

import com.google.android.gms.tasks.OnFailureListener;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DatabaseHelper {
    Boolean bool;
    //FirebaseFirestore db;
    FirebaseDatabase database;
    DatabaseReference myref;
    public DatabaseHelper(){
        //FirebaseFirestore db=FirebaseFirestore.getInstance();
        database=FirebaseDatabase.getInstance();
        myref=database.getReference("UserInfo");

        //Log.e("TAG",db.toString());
    }

    public Map<String,String> getuserinfoR(String email){
        final Map<String,String> arr=new HashMap<>();
       DatabaseReference prref=myref.child(email.substring(0,email.length()-9)).child("NAME");
       prref.addListenerForSingleValueEvent(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
               try {
                   arr.put("NAME", dataSnapshot.getValue().toString());
               } catch (Exception e) {

                   e.printStackTrace();
               }

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {


           }
       });
        DatabaseReference prref5=myref.child(email.substring(0,email.length()-9)).child("INTEREST");
        prref5.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("INTEREST",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref6=myref.child(email.substring(0,email.length()-9)).child("EMI");
        prref6.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("EMI",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref7=myref.child(email.substring(0,email.length()-9)).child("GENDER");
        prref7.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("GENDER",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref8=myref.child(email.substring(0,email.length()-9)).child("PHONENO");
        prref8.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("PHONENO",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref9=myref.child(email.substring(0,email.length()-9)).child("TOTALMONEY");
        prref9.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //arr.put("TOTALMONEY",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref10=myref.child(email.substring(0,email.length()-9)).child("DOB");
        prref10.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("DOB",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        DatabaseReference prref11=myref.child(email.substring(0,email.length()-9)).child("ADDRESS");
        prref11.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                arr.put("ADDRESS",dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return arr;
    }
    public Map<String,String> getuserinfo(String email){
        /*if(db==null){
            Log.e("TAG","HURRAY");
        }
        final DocumentReference docRef = db.collection("Users").document(email);
        final Map<String,String> userdata=new HashMap<>();
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    DocumentSnapshot document = task.getResult();
                    if (document.exists()) {

                        userdata.put("NAME",document.get("NAME").toString());
                        userdata.put("INTEREST",document.get("INTEREST").toString());
                        userdata.put("EMI",document.get("EMI").toString());
                        userdata.put("GENDER",document.get("GENDER").toString());
                        userdata.put("PHONENUMBER",document.get("PHONENUMBER").toString());
                        userdata.put("TOTALMONEY",document.get("EMI").toString());
                        userdata.put("DOB",document.get("DOB").toString());
                        userdata.put("ADDRESS",document.get("ADDRESS").toString());

                        Log.d("TAG", "DocumentSnapshot data: " + document.getData());

                    } else {
                        Log.d("TAG", "No such document");
                    }
                } else {
                    Log.d("TAG", "get failed with ", task.getException());
                }
            }
        });*/
        return null;
    }
    public void putuserinoR(String Name,String interest,String Totalpay,String emi,String Gender,String Phonenumber,String DOB,String Address,String email){
        Map<String, String> user = new HashMap<>();
        user.put("NAME",Name);
        user.put("INTEREST", interest);
        user.put("EMI",emi );
        user.put("GENDER",Gender);
        user.put("PHONENO",Phonenumber);
        user.put("DOB",DOB);
        user.put("ADDRESS",Address);
        user.put("TOTALMONEY", Totalpay);

        DatabaseReference refer=myref.child(email.substring(0,email.length()-9)).push().child("NAME");
        refer.setValue(user.get("NAME"));
        DatabaseReference refer1=myref.child(email.substring(0,email.length()-9)).push().child("INTEREST");
        refer1.setValue(user.get("INTEREST"));
        DatabaseReference refer2=myref.child(email.substring(0,email.length()-9)).push().child("EMI");
        refer2.setValue(user.get("EMI"));
        DatabaseReference refer3=myref.child(email.substring(0,email.length()-9)).push().child("GENDER");
        refer3.setValue(user.get("GENDER"));
        DatabaseReference refer4=myref.child(email.substring(0,email.length()-9)).push().child("PHONENO");
        refer4.setValue(user.get("PHONENO"));
        DatabaseReference refer5=myref.child(email.substring(0,email.length()-9)).push().child("DOB");
        refer5.setValue(user.get("DOB"));
        DatabaseReference refer6=myref.child(email.substring(0,email.length()-9)).push().child("ADDRESS");
        refer6.setValue(user.get("ADDRESS"));
        //DatabaseReference refer7=myref.push().child(email).push().child("NAME");
      //  refer7.setValue(user.get("NAME"));
        DatabaseReference refer8=myref.child(email.substring(0,email.length()-9)).push().child("TOTALMONEY");
        refer8.setValue(user.get("TOTALMONEY"));
    }
    public void putuserinfo(String Name,String interest,String Totalpay,String emi,String Gender,String Phonenumber,String DOB,String Address,String email) {


        Map<String, Object> user = new HashMap<>();
        user.put("NAME",Name);
        user.put("INTEREST", interest);
        user.put("EMI",emi );
        user.put("GENDER",Gender);
        user.put("PHONENO",Phonenumber);
        user.put("DOB",DOB);
        user.put("ADDRESS",Address);
        user.put("TOTALMONEY", Totalpay);

       // DocumentReference ref=db.collection("Users").document(email);
        //ref.set(user).addOnCompleteListener(new OnCompleteListener<Void>() {
          //  @Override
          //  public void onComplete(@NonNull Task<Void> task) {
         //       Log.d("TASK","TASKSUCCESS");
           // }
        //}).addOnFailureListener(new OnFailureListener() {
          //  @Override
           // public void onFailure(@NonNull Exception e) {
           //     Log.e("TASK","It failed");
           // }
       // });
    }

    public Map<String,Object> getcommunityinfo(String CommunityUniqueID){
       // final DocumentReference documentReference=db.collection("CommunityINFO").document(CommunityUniqueID);
        final Map<String,Object> map=new HashMap<>();
        /*documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()){
                    DocumentSnapshot documentSnapshot=task.getResult();
                    if(documentSnapshot.exists()){
                        map.put("COMMNAME",documentSnapshot.get("COMMNAME"));
                        map.put("COMMLOCATION",documentSnapshot.get("COMMLOACATION"));
                        map.put("HEADID",documentSnapshot.get("HEADID"));
                        map.put("USERS",documentSnapshot.get("USERS"));

                    }
                }

            }}
        );*/
        return map;
    }
    //public Map<String,Object> getcommunityinfo()
    public void updatecomminfo(String CommunityUniqueID, String location, String Headid, ArrayList<String> users){
        Map<String,Object> map=new HashMap<>();
        map.put("COMMNAME",CommunityUniqueID);
        map.put("COMMLOCATION",location);
        map.put("HEADID",Headid);
        map.put("USERS",(Object)users);
        //DocumentReference ref=db.collection("CommunityINFO").document(CommunityUniqueID);
        /*ref.set(map).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void aVoid) {
                //No idea what to do here.
            }
        });*/
    }

    public Map<String,Object> getBalanceSheet(String CommunityUniqueID){
        Map<String,Object> map=new HashMap<>();
      //  DocumentReference documentReference=db.collection("BalanceSheet").document(CommunityUniqueID);
       /* documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {

            }
        });*/
        return map;
    }
    public boolean checkifidunique(String CommunityID){

       // DocumentReference documentReference=db.collection("BalanceSheet").document(CommunityID);
        /*documentReference.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                bool=false;
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                bool=true;
            }
        });*/
        return bool;
    }

}