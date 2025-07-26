package com.royal;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignupActivity extends AppCompatActivity {


    EditText edtFirstName;
    EditText edtLastName;
    EditText edtEmail;
    EditText edtPassword;
    Button btnSignup;

    RadioButton rbt;

    TextView tvLoginLink;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //bind - connect
        edtFirstName = findViewById(R.id.edtFirstName);
        edtLastName = findViewById(R.id.edtLastName);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        btnSignup = findViewById(R.id.btnSignup);
        tvLoginLink = findViewById(R.id.tvSignupLoginLink);
        rbt = findViewById(R.id.rbt);

//        rbt.setChecked(true);

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //read
                String firstName = edtFirstName.getText().toString();
                String lastName = edtLastName.getText().toString();
                String email= edtEmail.getText().toString();
                String password = edtPassword.getText().toString();

                //Logcat
                Log.i("SignupActivity",firstName);
                Log.i("SignupActivity",lastName);
                Log.i("SignupActivity",email);
                Log.i("SignupActivity",password);

                //validation

                boolean isError = false;

                if(firstName.isEmpty()){
                    isError = true;
                    edtFirstName.setError("Please Enter FirstName");
                }

                if(lastName.isEmpty()){
                    isError = true;
                    edtLastName.setError("Please Enter LastName");
                }

                if(email.isEmpty()){
                    isError = true;
                    edtEmail.setError("Please Enter Email");
                }

                if(password.isEmpty()){
                    isError = true;
                    edtPassword.setError("Please Enter Password");
                }

                if(isError == false) {


                    //api

                    //Toast

                    Toast.makeText(getApplicationContext(),"Successfully registered",Toast.LENGTH_LONG).show();

                    //navigate to Login Activity
                    Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                    startActivity(intent);

                }

            }
        });


        tvLoginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });




    }
}