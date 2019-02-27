package com.mihaita.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout dl;
    private ActionBarDrawerToggle t;

    double numberOne, numberTwo, total;

    boolean addBtnPressed, subtractBtnPressed, divideBtnPressed, multiplyBtnPressed, equalBtnPressed,
            anyMathBtnPressed, firstNumberPressed, secondNumberPressed, calculationFinished;

    ArrayList<String> history = new ArrayList<>();


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
                bAdd = findViewById(R.id.btn_add), bSubtract = findViewById(R.id.btn_sub),
                bMultiply = findViewById(R.id.btn_multiply), bDivide = findViewById(R.id.btn_divide),
                bDel = findViewById(R.id.btn_del), bPercentage = findViewById(R.id.btn_percent),
                bPozNeg = findViewById(R.id.btn_sign), bClear = findViewById(R.id.btn_clear);
        //TextView result = findViewById(R.id.textView_calculation);


        //missing some cases for zero number
        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "0");
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "1");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "2");
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "3");
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "4");
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "5");
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "6");
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "7");
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "8");
            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mathButtonPressed(anyMathBtnPressed, "9");
            }
        });
        bDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = findViewById(R.id.textView_calculation);
                result.setText(result.getText().toString() + ".");
                history.add(".");
            }
        });
        bEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doMathCalculation();
                equalBtnPressed = true;

                secondNumberPressed = false;
                addBtnPressed = false;
                subtractBtnPressed = false;
                divideBtnPressed = false;
                multiplyBtnPressed = false;
                anyMathBtnPressed = false;

                TextView result = findViewById(R.id.textView_calculation);
                //putin diferit aici
                history.add("=" + result.getText().toString() + "\n");

            }
        });
        bAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirstNumberForCalculation();
                addBtnPressed = true;
                history.add("+");
            }
        });
        bSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirstNumberForCalculation();
                subtractBtnPressed = true;
                history.add("-");
            }
        });
        bMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirstNumberForCalculation();
                multiplyBtnPressed = true;
                history.add("*");
            }
        });
        bDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFirstNumberForCalculation();
                divideBtnPressed = true;
                history.add("/");
            }
        });
        bDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = findViewById(R.id.textView_calculation);
                result.setText("");
                history.add("DEL");
            }
        });
        bPercentage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = findViewById(R.id.textView_calculation);
                result.setText(String.valueOf(Double.parseDouble(result.getText().toString()) / 100));
                history.add("%");
            }
        });
        bPozNeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = findViewById(R.id.textView_calculation);
                result.setText(String.valueOf(Double.parseDouble(result.getText().toString()) * -1));
                history.add("+/-");
            }
        });
        bClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView result = findViewById(R.id.textView_calculation);
                result.setText("0");
                numberOne = 0;
                numberTwo = 0;
                anyMathBtnPressed = false;
                firstNumberPressed = false;
                addBtnPressed = false;
                subtractBtnPressed = false;
                multiplyBtnPressed = false;
                divideBtnPressed = false;
                calculationFinished = false;
                history.add("C\n");
            }
        });
    }

    public void mathButtonPressed(boolean mathBtnPressed, String number) {
        TextView result = findViewById(R.id.textView_calculation);

        if (mathBtnPressed == true || equalBtnPressed == true) {
            result.setText("");
        }

        result.setText((result.getText().toString().equals("0")) ? number : result.getText() + number);

        anyMathBtnPressed = false;
        equalBtnPressed = false;
        firstNumberPressed = true;

        history.add(number);
    }

    public void getFirstNumberForCalculation() {
        secondNumberPressed = true;

        TextView result = findViewById(R.id.textView_calculation);

        if (!result.getText().toString().isEmpty() && secondNumberPressed == true) {
            anyMathBtnPressed = true;

            doMathCalculation();

            numberOne = Double.parseDouble(result.getText().toString());
        }

        addBtnPressed = false;
        subtractBtnPressed = false;
        divideBtnPressed = false;
        multiplyBtnPressed = false;

    }

    public void doMathCalculation() {
        TextView result = findViewById(R.id.textView_calculation);

        if (secondNumberPressed == true && calculationFinished == true && equalBtnPressed == false) {
            numberOne = Double.parseDouble(result.getText().toString());
        } else {
            numberTwo = Double.parseDouble(result.getText().toString());
        }


        if (addBtnPressed == true) {
            total = numberOne + numberTwo;
        } else if (subtractBtnPressed == true) {
            total = numberOne - numberTwo;
        } else if (divideBtnPressed == true && numberTwo != 0) {
            total = numberOne / numberTwo;
        } else if (multiplyBtnPressed == true) {
            total = numberOne * numberTwo;
        } else {
            total = numberTwo;
        }

        result.setText(String.valueOf(total));

        secondNumberPressed = false;
        calculationFinished = true;

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

            Intent i = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.nav_history) {
            Intent i = new Intent(getApplicationContext(), HistoryActivity.class);
            String completeHistory = "";

            for (String s : history) {
                completeHistory += s + "\t";
            }

            i.putExtra("value", completeHistory);
            startActivity(i);

        }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }


}
