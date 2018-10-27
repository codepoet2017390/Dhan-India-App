package com.rohan.hashhacks30;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 NavigationView navigationView;
 DrawerLayout drawer;
 int navItemIndex;
    TextView name;
    TextView communityName;
    TextView investedAmount;
    TextView earning;
    String naam;
    TextView amountWithdrawn;

    @Override
    protected void onStart() {
        super.onStart();
//        if(!getIntent().getExtras().getString("status").equals("OK"))
//        {
//            Intent i=new Intent(MainActivity.this,Login.class);
//            startActivity(i);
//
//        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView=findViewById(R.id.nav_view);
        drawer=findViewById(R.id.drawer);
        setUpNavigationView();
        name=findViewById(R.id.nameTextView);
        communityName=findViewById(R.id.communityName);
        investedAmount=findViewById(R.id.totalInvested);
        earning=findViewById(R.id.earnedamount);
        amountWithdrawn=findViewById(R.id.withdrawn);
        investedAmount.setText("10000");
        earning.setText("10500");
        amountWithdrawn.setText(Integer.toString(LoanPropose.loanAmount));
    }
    private void setUpNavigationView(){
        //Setting Navigation View Item Selected Listener to handle the item click of the navigation menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                //Check to see which item was being clicked and perform appropriate action
                switch (menuItem.getItemId()) {
                    //Replacing the main content with ContentFragment Which is our Inbox View;
                    case R.id.nav_home:
                        navItemIndex = 0;
//                        CURRENT_TAG = TAG_HOME;
                        if (drawer.isDrawerOpen(GravityCompat.START)) {
                            drawer.closeDrawers();
                        }
                        break;
                    /*case R.id.nav_notifichghgations:
                        navItemIndex = 1;
                        CURRENT_TAG = TAG_NOTIFICATIONS;
                        break;*/
                    case R.id.nav_Community_data:
                        navItemIndex = 0;
//                        CURRENT_TAG = TAG_HOME;
                        if (drawer.isDrawerOpen(GravityCompat.START)) {
                            drawer.closeDrawers();
                        }
                        Intent i=new Intent(MainActivity.this,CommunitySheet.class);
                        startActivity(i);
                        break;
                    case R.id.nav_myaccount:
                        navItemIndex = 2;
                        //CURRENT_TAG = TAG_SETTINGS;
                        Intent intent = new Intent(MainActivity.this, PersonInfo.class);
                        startActivity(intent);
                        return true;

                    case R.id.nav_Community_chat:
                        // launch new intent instead of loading fragment
                        startActivity(new Intent(MainActivity.this, MainChatActivity.class));
                        drawer.closeDrawers();
                        return true;
                    case R.id.nav_ask:
                        Toast.makeText(getApplicationContext(), "User logged out", Toast.LENGTH_LONG).show();
                        Intent intent3 = new Intent(MainActivity.this, LoanPropose.class);
                        intent3.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent3);
                        return true;


//                        case R.id.nav_contact_us :
//                            viewPager.setCurrentItem(2);
//                            // Intent intent2 = new Intent(MainActivity.this, PopSearch.class);
//                            // startActivity(intent2);
//                            if (drawer.isDrawerOpen(GravityCompat.START)) {
//                                drawer.closeDrawers();
//                            }
//                            return true;

                    default:
                        navItemIndex = 0;
                }
                //Checking if the item is in checked state or not, if not make it in checked state
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                menuItem.setChecked(true);
                //loadHomeFragment();
                return true;
            }
        });
    }
}
