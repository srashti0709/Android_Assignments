package com.example.assignment3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button addBtn, subBtn, mulBtn, divBtn;
    TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);

        addBtn = findViewById(R.id.addBtn);
        subBtn = findViewById(R.id.subBtn);
        mulBtn = findViewById(R.id.mulBtn);
        divBtn = findViewById(R.id.divBtn);

        resultText = findViewById(R.id.resultText);

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("+");
            }
        });

        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("-");
            }
        });

        mulBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("*");
            }
        });

        divBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculate("/");
            }
        });
    }

    private void calculate(String operator) {

        String first = num1.getText().toString();
        String second = num2.getText().toString();

        if (first.isEmpty() || second.isEmpty()) {
            Toast.makeText(this, "Please enter both numbers", Toast.LENGTH_SHORT).show();
            return;
        }

        double n1 = Double.parseDouble(first);
        double n2 = Double.parseDouble(second);

        double result = 0;

        switch (operator) {

            case "+":
                result = n1 + n2;
                break;

            case "-":
                result = n1 - n2;
                break;

            case "*":
                result = n1 * n2;
                break;

            case "/":
                if (n2 == 0) {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                    return;
                }
                result = n1 / n2;
                break;
        }

        resultText.setText("Result: " + result);
    }
}