package com.mihaita.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //modify action bar
        dl = (DrawerLayout) findViewById(R.id.drawer_layout);
        t = new ActionBarDrawerToggle
                (this, dl, R.string.nav_open, R.string.nav_close);
        dl.addDrawerListener(t);
        t.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nv = findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(this);

        Button b0 = findViewById(R.id.btn_zero), b1 = findViewById(R.id.btn_1),
                b2 = findViewById(R.id.btn_2), b3 = findViewById(R.id.btn_3),
                b4 = findViewById(R.id.btn_4), b5 = findViewById(R.id.btn_5),
                b6 = findViewById(R.id.btn_6), b7 = findViewById(R.id.btn_7),
                b8 = findViewById(R.id.btn_8), b9 = findViewById(R.id.btn_9),
                bDot = findViewById(R.id.btn_dot), bEqual = findViewById(R.id.btn_equal),
                bAdd = findViewById(R.id.btn_add), bSubstract = findViewById(R.id.btn_sub),
                bMultiply = findViewById(R.id.btn_multiply), bDivide = findViewById(R.id.btn_divide),
                bDel = findViewById(R.id.btn_del), bPercentage = findViewById(R.id.btn_percent),
                bPozNeg = findViewById(R.id.btn_sign), bClear = findViewById(R.id.btn_clear);
        TextView tvCalculations = findViewById(R.id.textView_calculation);


    }

    //make menu clickable
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (t.onOptionsItemSelected(item))
            return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.nav_about) {

            Intent i = new Intent(getApplicationContext(), HistoryActivity.class);
            startActivity(i);
        }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}
