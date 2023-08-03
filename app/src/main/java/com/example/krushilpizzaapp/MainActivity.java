package com.example.krushilpizzaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements CompoundButton.OnCheckedChangeListener {

    // Buttons
    Button btnM, btnP,btnC,btnG,btnS,btnOrder;
    int total = 0,priceM = 100, priceP = 200, priceC = 300, priceG = 150, priceS = 180;
    // Radio Group
    RadioGroup RG;
    RadioButton rb;
    // CheckBox
    CheckBox BC,OR,JP,OL;
    String CBValue = "";
    // Spinner
    Spinner sp;
    String mode="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnM = findViewById(R.id.btnMargerita);
        btnP = findViewById(R.id.btnPaneer);
        btnC = findViewById(R.id.btnChessey);
        btnG = findViewById(R.id.btnGB);
        btnS = findViewById(R.id.btnSC);
        btnOrder = findViewById(R.id.btnOrder);

        btnM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = total + priceM;
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
            }
        });

        btnP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = total + priceP;
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = total + priceC;
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
            }
        });

        btnG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = total + priceG;
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                total = total + priceS;
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
            }
        });

        RG = findViewById(R.id.radioGroup);
        RG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedID = RG.getCheckedRadioButtonId();
                rb = findViewById(selectedID);
                Toast.makeText(getApplicationContext(),"" + rb.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"" + total,Toast.LENGTH_LONG).show();
                String tb = String.valueOf(total);
                Intent data = new Intent(getApplicationContext(),Data.class);
                data.putExtra("TotalBill",tb);
                data.putExtra("PizzaSize",rb.getText().toString());
                data.putExtra("toppings",CBValue);
                data.putExtra("PM",mode);
                startActivity(data);
            }
        });

        BC = findViewById(R.id.cbBabyCorn);
        OR = findViewById(R.id.cbOraganoes);
        JP = findViewById(R.id.cbJalepenoes);
        OL = findViewById(R.id.cbOlives);

        BC.setOnCheckedChangeListener(this);
        OR.setOnCheckedChangeListener(this);
        JP.setOnCheckedChangeListener(this);
        OL.setOnCheckedChangeListener(this);

        sp = findViewById(R.id.MOP);
        String [] ap = getResources().getStringArray(R.array.paymentMethod);
        ArrayAdapter<String> pm = new ArrayAdapter<>(getApplicationContext(), com.google.android.material.R.layout.support_simple_spinner_dropdown_item,ap);
        sp.setAdapter(pm);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                mode = sp.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(buttonView.isChecked())
        {
            CBValue = CBValue + buttonView.getText().toString();
            Toast.makeText(getApplicationContext(),"" + CBValue,Toast.LENGTH_LONG).show();
        }
    }
}