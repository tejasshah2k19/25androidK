package com.royal;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculatorActivity extends AppCompatActivity {

    EditText display;
    String currentInput = "";
    double firstNum = 0;
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        display = findViewById(R.id.display);

        int[] digitIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9
        };






















        for (int id : digitIds) {
            findViewById(id).setOnClickListener(v -> {
                Button b = (Button) v;
                currentInput += b.getText().toString();
                display.setText(currentInput);
            });
        }

        findViewById(R.id.btnAdd).setOnClickListener(v -> handleOperator("+"));
        findViewById(R.id.btnSub).setOnClickListener(v -> handleOperator("-"));
        findViewById(R.id.btnMul).setOnClickListener(v -> handleOperator("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> handleOperator("/"));

        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());

        findViewById(R.id.btnClear).setOnClickListener(v -> {
            currentInput = "";
            operator = "";
            firstNum = 0;
            display.setText("");
        });
    }

    private void handleOperator(String op) {
        if (!currentInput.isEmpty()) {
            firstNum = Double.parseDouble(currentInput);
            operator = op;
            currentInput = "";
        }
    }

    private void calculate() {
        if (!currentInput.isEmpty() && !operator.isEmpty()) {
            double secondNum = Double.parseDouble(currentInput);
            double result = 0;

            switch (operator) {
                case "+": result = firstNum + secondNum; break;
                case "-": result = firstNum - secondNum; break;
                case "*": result = firstNum * secondNum; break;
                case "/":
                    if (secondNum != 0) result = firstNum / secondNum;
                    else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }

            display.setText(String.valueOf(result));
            currentInput = String.valueOf(result);
            operator = "";
        }
    }
}
