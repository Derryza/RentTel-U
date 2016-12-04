package com.tubes.me.renttel_u;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Booking extends AppCompatActivity {

    private Button mBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tugas1);

        /*mBooking = (Button) findViewById(R.id.bookingbtn);
        mBooking.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Menunggu konfirmasi", Toast
                        .LENGTH_SHORT).show();
            }
        });*/
    }

    public void LihatMaps (View v){
        startActivity(new Intent(Booking.this, MapsActivity.class));
    }

    public void Telepon (View v){
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:085726567333"));
        startActivity(intent);
    }

    public void kirimpesan (View v){

        Uri sms_uri = Uri.parse("smsto:085726567333");
        Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
        sms_intent.putExtra("sms_body", "Rental Motor");
        startActivity(sms_intent);
    }
}
