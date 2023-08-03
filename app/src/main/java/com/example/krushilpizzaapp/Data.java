package com.example.krushilpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Data extends AppCompatActivity {

    TextView TB,PS,PT,PM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        TB = findViewById(R.id.totalBill);
        String bill = this.getIntent().getStringExtra("TotalBill");
        TB.setText( "Total BIll is: " + bill);

        PS = findViewById(R.id.pizzaSizes);
        String size = this.getIntent().getStringExtra("PizzaSize");
        PS.setText("Pizza Size is: " + size);

        PT = findViewById(R.id.pizzaToppings);
        String pt = this.getIntent().getStringExtra("toppings");
        PT.setText("Selected Toppings: " + pt);

        PM  = findViewById(R.id.PM);
        String m = this.getIntent().getStringExtra("PM");
        PM.setText("Payment Method: " + m);
    }
}