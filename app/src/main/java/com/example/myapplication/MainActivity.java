package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button login = findViewById(R.id.login);
        Button register = findViewById(R.id.register);

        final EditText username = findViewById(R.id.username);
        final EditText password = findViewById(R.id.password);

        register.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent GotoRegisterActivity = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(GotoRegisterActivity);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username.setError(null);
                password.setError(null);
                if(!Validation.isValidUsername(username.getText().toString())){
                    username.setError("Klaida! Patikrinkite slapyvardi!");
                    username.requestFocus();
                }
                else if(!Validation.isValidPassword(password.getText().toString())){
                    password.setError("Klaida! Patikrinkite slaptazodi!");
                    password.requestFocus();
                }
                else {
                    Intent GotoSearchActivity = new Intent(MainActivity.this, SearchActivity.class);
                    startActivity(GotoSearchActivity);
                }
            }
        });

    }
}