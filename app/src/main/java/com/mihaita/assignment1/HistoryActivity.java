package com.mihaita.assignment1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        Button b = findViewById(R.id.btn_goBackFromHistory);

        Intent intentHistory = getIntent();

        TextView tvHistory = findViewById(R.id.tv_receiveHistory);

        String history = intentHistory.getStringExtra("value");


        tvHistory.setText(history);

    }
}
