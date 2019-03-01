package com.mihaita.assignment1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static android.provider.CalendarContract.CalendarCache.URI;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Button b = findViewById(R.id.btn_goBackFromAbout);
        Button emailMe = findViewById(R.id.btn_emailMe);


        final Intent i= new Intent(this, MainActivity.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                AboutActivity.super.finish();
            }
        });

        final Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                emailIntent.setData(Uri.parse("mailto:lacatus.mihaita@gmail.com"));

            }
        });





    }


}
