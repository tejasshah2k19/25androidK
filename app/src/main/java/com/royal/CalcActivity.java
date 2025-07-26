package com.royal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalcActivity extends AppCompatActivity {

    EditText edtInput;
    Button btn1;
    Button btn2;

    Button btn[] = new Button[10];//0-9
    Button btnAns;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calc);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtInput = findViewById(R.id.edtCalcInput);

        int ids[] = { R.id.btnCal0,R.id.btnCal1,R.id.btnCal2};

        int x = 0;
        for(int i:ids){
            btn[x] = findViewById(i);
            final int idvalue  = x;
            btn[x].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String input = edtInput.getText().toString()+idvalue+"";
                    edtInput.setText(input);
                }
            });
            x++;
        }

    //+ - * /

        btnAns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input = edtInput.getText().toString();

                //25+63
                if(input.contains("+")){
                   String data [] =  input.split("\\+");
                   //data[0] => 25
                    //data[1] => 63
                    int ans = Integer.parseInt(data[0]) + Integer.parseInt(data[1]);
                    edtInput.setText(ans+"");
                }
                //25-63
                //25*63
                //25/63


            }
        });
    }
}