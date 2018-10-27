package com.rohan.hashhacks30;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.auth.IdpResponse;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Arrays;
import java.util.List;

public class Login extends AppCompatActivity {
public int RC_SIGN_IN=123;
public  FirebaseUser user;
    private SharedPreferences sharedPref;
//    FirebaseAuth auth = FirebaseAuth.getInstance();
    FirebaseAuth.AuthStateListener authListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
            if (firebaseUser != null) {
                //String userId = firebaseUser.getUid();
                String userEmail = firebaseUser.getEmail();
                sharedPref = getPreferences(MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("firebasekey", userEmail);
                editor.commit();
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.EmailBuilder().build());


// Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            IdpResponse response = IdpResponse.fromResultIntent(data);

            if (resultCode == RESULT_OK) {
                // Successfully signed in
                user = FirebaseAuth.getInstance().getCurrentUser();
                Intent i=new Intent(Login.this,MainActivity.class);
                // ...
            } else {
                Toast.makeText(getApplicationContext(),"LOGIN FAILED",Toast.LENGTH_LONG).show();
                // Sign in failed. If response is null the user canceled the
                // sign-in flow using the back button. Otherwise check
                // response.getError().getErrorCode() and handle the error.
                // ...
            }
        }
    }
}
