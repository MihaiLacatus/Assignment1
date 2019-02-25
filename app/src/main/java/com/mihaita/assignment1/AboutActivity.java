package com.mihaita.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button b = findViewById(R.id.btn_goBack);
        final Intent i= new Intent(this, MainActivity.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                AboutActivity.super.finish();
            }
        });


    }

//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//
//        Button b = findViewById(R.id.btn_goBack);
//
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent (getApplicationContext(),MainActivity.class);
//                startActivity(i);
//
//            }
//        });
//
//
//    }
}
