package com.mihaita.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);



        Intent intentHistory = getIntent();

        TextView tvHistory = findViewById(R.id.tv_receiveHistory);

        String history = intentHistory.getStringExtra("value");


        tvHistory.setText(history);

        //Button b = findViewById(R.id.btn_goBackFromHistory);

    }


    @Override
    protected void onStart() {
        super.onStart();

        Button b = findViewById(R.id.btn_goBackFromHistory);

        final Intent i = new Intent(getApplicationContext(),MainActivity.class);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);

                HistoryActivity.super.finish();
            }
        });


    }
}
