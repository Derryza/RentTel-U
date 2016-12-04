package com.tubes.me.renttel_u;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.tubes.me.renttel_u.Helper.BaseHelper;
import com.tubes.me.renttel_u.Helper.HelperRental;
import com.tubes.me.renttel_u.Model.Rental;

import java.util.List;

public class MainActivity extends AppCompatActivity {


   /* private TextView textViewName;
    private TextView textViewEmail;*/

    //inisialisasi button

    private ProgressDialog mProgressDialog;

    private SignInButton signInButton;

    private static final int RC_SIGN_IN = 1;

    private Context ctx;

    private GoogleApiClient mGoogleApiClient;

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    private static final String TAG="Main_Activity";

    private SharedPreferences sf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);



        BaseHelper bh = new BaseHelper(getApplicationContext());

        Rental rental = new Rental(1, "Derry", "derry.jatnika@gmail.com", "Bandung", "08572656733", "satu");
        HelperRental hr = new HelperRental(bh.getWritableDatabase());

        hr.createRental(rental, bh.getDateTime());
//        hr.createRental(rental2, bh.getDateTime());
//        hr.createRental(rental3, bh.getDateTime());

        Log.i("Tes", "tes" + hr.getAllToDos().size());

        List<Rental> rent = hr.getAllToDos();
        for (Rental r : rent ){
            Log.i("rent", "email"+r.getEmail());
            Log.i("rent", "passwd"+r.getPassword());
        }

        Rental rn = hr.getRentalLogin("derry.jatnika@gmail.com", "satu");
        Log.i("email", rn.getEmail());
        Log.i("passwd", rn.getPassword());

        // set id rental di shared preferences
        sf = this.getPreferences(Context.MODE_PRIVATE);
        sf.edit().putInt("id_rental", rn.getId_rental());
        sf.edit().commit();

        // ambil id renal di shared pref
        int id_rental = sf.getInt("id_rental", 1);
        Log.i("id_rental", "id: "+id_rental);

        /*//Initializing Views
        textViewName = (TextView) findViewById(R.id.textviewnama);
        textViewEmail = (TextView) findViewById(R.id.textView);*/

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                if (firebaseAuth.getCurrentUser() != null ){
                    startActivity(new Intent(MainActivity.this, DrawerActivity.class));
                }
            }
        };

        //inisialisasi button sign google
        signInButton = (SignInButton) findViewById(R.id.sign_in_button);

        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions
                .DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext())
                .enableAutoManage(this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                })
                .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                .build();

        signInButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                signIn();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                firebaseAuthWithGoogle(account);

               /* GoogleSignInAccount acct = result.getSignInAccount();

                //Displaying name and email
                textViewName.setText(acct.getDisplayName());
                textViewEmail.setText(acct.getEmail());*/

            } else {
                //If login fails
                Toast.makeText(this, "Gagal Masuk", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void firebaseAuthWithGoogle(GoogleSignInAccount account) {

        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d(TAG, "signInWithCredential:onComplete:" + task.isSuccessful());

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "signInWithCredential", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        // ...
                    }
                });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // this line close the  app on backpress
    }

    protected void onStop() {
        super.onStop();

        if (mGoogleApiClient.isConnected()) {
            mGoogleApiClient.disconnect();
        }
    }

    private void showProgressDialog() {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(this);
            mProgressDialog.setMessage(getString(R.string.loadingg));
            mProgressDialog.setIndeterminate(true);
        }

        mProgressDialog.show();
    }

    private void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.hide();
        }
    }
}