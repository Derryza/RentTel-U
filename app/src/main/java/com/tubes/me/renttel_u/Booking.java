package com.tubes.me.renttel_u;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Booking extends AppCompatActivity {

    private Button mBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        mBooking = (Button) findViewById(R.id.bookingbtn);
        mBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Menunggu konfirmasi", Toast
                        .LENGTH_SHORT).show();
            }
        });
    }

}
