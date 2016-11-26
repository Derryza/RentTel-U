package com.tubes.me.renttel_u;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

public class DrawerActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener {


    private ListView lvList;
    private ListAdapter adapter;
    private List<Listnya> mListnyaList;

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                if (firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(DrawerActivity.this, MainActivity.class));

                }

            }
        };

        lvList = (ListView)findViewById(R.id.listview);
        mListnyaList = new ArrayList<>();

        mListnyaList.add(new Listnya(1, "Honda Beat", "Abi Rental", 50000));
        mListnyaList.add(new Listnya(2, "Honda Vario", "Roda 99 Rental", 50000));
        mListnyaList.add(new Listnya(3, "Yamaha Mio", "Abi Rental", 50000));
        mListnyaList.add(new Listnya(4, "Yamaha Xride", "Roda 99 Rental", 50000));
        mListnyaList.add(new Listnya(5, "Honda Vario 125", "Apri Rental", 50000));
        mListnyaList.add(new Listnya(6, "Honda CBR", "Cia Rental", 50000));
        mListnyaList.add(new Listnya(7, "Yamaha Mio Vino", "Aris rental", 50000));
        mListnyaList.add(new Listnya(8, "Suzuki Spin", "Rio Rental", 50000));
        mListnyaList.add(new Listnya(9, "Yamaha Jupiter MX", "Roda 99 Rental", 50000));
        mListnyaList.add(new Listnya(10, "Suzuki Satria FU", "Roda 99 Rental", 50000));


        adapter = new com.tubes.me.renttel_u.ListAdapter(getApplicationContext(), mListnyaList);
        lvList.setAdapter(adapter);

        lvList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getApplicationContext(), "memilih list " + view.getTag(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(DrawerActivity.this, Booking.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(DrawerActivity.this, AccountActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}