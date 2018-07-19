package com.example.adsl4.aarogya;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {
EditText edtWeight,edtHeight;
Spinner spnWeight,spnHeight;
double weight,height;
Button btnCalculate;
String condition;
TextView txtBmi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        this.setTitle("Aarogya: BMI Calculator");

        edtHeight=findViewById(R.id.edtHeight);
        edtWeight=findViewById(R.id.edtWeight);

        spnHeight=findViewById(R.id.spnHeight);
        spnWeight=findViewById(R.id.spnWeight);



        txtBmi=findViewById(R.id.txtBMIResult);

        btnCalculate=findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (spnHeight.getSelectedItemPosition()==0){
                    height=Float.parseFloat(edtHeight.getText().toString())*0.0254;

                }
                else {
                    height = Float.parseFloat(edtHeight.getText().toString()) * 0.01;
                }

                weight=Float.parseFloat(edtWeight.getText().toString());
                double bmi=weight/(height*height);
                if(bmi<=15)
                {
                    condition="<b>Very severely underweight.</b>";
                }
                else if(bmi<=16){
                    condition="<b>Severely underweight.</b>";
                }
                else if(bmi<=18.5){
                    condition="Underweight.";
                }
                else if(bmi<=25){
                    condition="Normal (healthy weight).";
                }
                else if(bmi<=30){
                    condition="Overweight.";
                }
                else if(bmi<=35){
                    condition="Moderately obese.";
                }
                else if(bmi<=40){
                    condition="Severely obese.";
                }
                else if(bmi<=45){
                    condition="Very severely obese.";
                }
                else if(bmi<=50){
                    condition="Morbidly Obese.";
                }
                else if(bmi<=60){
                    condition="Super Obese.";
                }
                else if(bmi>60){
                    condition="Hyper Obese.";
                }
                txtBmi.setText("Your Body Mass Index is "+bmi+" This is considered "+condition);
            }
        });



    }
}
