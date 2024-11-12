package com.android.firstbmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText edtWeight, edtHeightFt, edtHeight;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;

        edtWeight =findViewById(R.id.edtWeight );
        edtHeightFt =findViewById(R.id.edtHeightFt);
        edtHeight=findViewById(R.id.edtHeightIn);
        btnCalculate =findViewById(R.id.btnCalculate);
        txtResult =findViewById(R.id.txtResult);
        llMain=findViewById(R.id.llmain);


      btnCalculate.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              int wt = Integer.parseInt(edtWeight.getText().toString());
              int ft = Integer.parseInt(edtHeightFt.getText().toString());
              int in = Integer.parseInt(edtHeight.getText().toString());

              int totalIn = ft * 12 + in;

              double totalCm = totalIn *2.53;

              double totalM = totalCm /100;

              double bmi = wt /(totalM*totalM);

              if (bmi >= 25) {
                  txtResult.setText("You are Overweight");
                //  llMain.setBackgroundColor(getResources().getColor(R.color.overweightColor));
              } else if (bmi >= 18.5) {
                  txtResult.setText("You are Underweight");
                 // llMain.setBackgroundColor(getResources().getColor(R.color.healthyColor));
              } else {
                  txtResult.setText("You are Healthy");
                 // llMain.setBackgroundColor(getResources().getColor(R.color.underweightColor));
              }
          }
      });
    }
}