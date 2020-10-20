package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        //button:
        Button register = findViewById(R.id.final_register_button);

        //EditText:
        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);
        final  EditText email = findViewById(R.id.email);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                username.setError(null);
                email.setError(null);
                password.setError(null);
                if(!Validation.isValidUsername(username.getText().toString())) {
                    username.setError("Klaida! Patikrinkite ivesta varda!");
                    username.requestFocus();
                }
                else if (!Validation.isValidEmail(email.getText().toString())){
                    email.setError("Klaida! Patikrinkite ivesta el. pasta!");
                    email.requestFocus();
                }
                else if(!Validation.isValidPassword(password.getText().toString())){
                    password.setError("Klaida! Patikrinkite ivesta slaptazodi!");
                    password.requestFocus();
                }
                else{
                    Intent GotoLoginActivity = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(GotoLoginActivity);
                }

            }
        });
        Button back = findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent GotoLoginActivity = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(GotoLoginActivity);
            }
        });
    }
}