package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    String oldNumber = "";
    String op = "+";
    boolean isNewOp = true;
    public EditText edit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.editText);
    }



    public void numberEvent(View view) {
        if (isNewOp)
            edit.setText("");
        isNewOp = false;
        String number = edit.getText().toString();
        switch (view.getId()){
            case R.id.buZero:
                number +="0";
                break;
            case R.id.buOne:
                number +="1";
                break;
            case R.id.buTwo:
                number +="2";
                break;
            case R.id.buThree:
                number +="3";
                break;
            case R.id.buFour:
                number +="4";
                break;
            case R.id.buFive:
                number +="5";
                break;
            case R.id.buSix:
                number +="6";
                break;
            case R.id.buSeven:
                number +="7";
                break;
            case R.id.buEight:
                number +="8";
                break;
            case R.id.buNine:
                number +="9";
                break;
            case R.id.buDot:
                number +=".";
                break;
            case R.id.buMinus:
                number ="-"+number;
                break;
        }
        edit.setText(number);

    }

    public void OperatorEvent(View view) {
        isNewOp = true;
        oldNumber = edit.getText().toString();
        switch (view.getId()){
            case R.id.buMult:
                op = "*";
                break;
            case R.id.buMinus:
                op = "-";
                break;
            case R.id.buPlus:
                op = "+";
                break;
            case R.id.buDivide:
                op = "/";
                break;
        }
    }

    public void equalsEvent(View view) {
        String newNumber =edit.getText().toString();
        double result = 0.0;
        switch (op){
            case "+":
            result = Double.parseDouble(oldNumber)+Double.parseDouble(newNumber) ;
            break;
            case "-":
                result = Double.parseDouble(oldNumber)-Double.parseDouble(newNumber) ;
                break;
            case "*":
                result = Double.parseDouble(oldNumber)*Double.parseDouble(newNumber) ;
                break;
            case "/":
                result = Double.parseDouble(oldNumber)/Double.parseDouble(newNumber) ;
                break;
        }
        edit.setText(result+"");
    }

    public void AcEvent(View view) {
        edit.setText("0");
        isNewOp= true;
    }

    public void PercentEvent(View view) {
        double no = Double.parseDouble(edit.getText().toString())/100;
        edit.setText(no+"");
        isNewOp = true;

    }

    public void squareEvent(View view) {
        double no = Double.parseDouble(edit.getText().toString())*Double.parseDouble(edit.getText().toString());
        edit.setText(no+"");
        isNewOp = true;
    }
}