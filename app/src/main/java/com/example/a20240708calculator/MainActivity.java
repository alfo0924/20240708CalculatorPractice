package com.example.a20240708calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextNum1, editTextNum2;
    private Button buttonAdd, buttonSubtract, buttonMultiply, buttonDivide;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNum1 = findViewById(R.id.text1);
        editTextNum2 = findViewById(R.id.text2);
        buttonAdd = findViewById(R.id.plus);
        buttonSubtract = findViewById(R.id.minus);
        buttonMultiply = findViewById(R.id.times);
        buttonDivide = findViewById(R.id.divide);
        textViewResult = findViewById(R.id.textView);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('+');
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('-');
            }
        });

        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('*');
            }
        });

        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performCalculation('/');
            }
        });
    }

    private void performCalculation(char operation) {
        try {
            double num1 = Double.parseDouble(editTextNum1.getText().toString());
            double num2 = Double.parseDouble(editTextNum2.getText().toString());
            double result = 0;

            switch (operation) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textViewResult.setText("Result: " + result);
        } catch (NumberFormatException e) {
            textViewResult.setText("Invalid input");
        }
    }
}