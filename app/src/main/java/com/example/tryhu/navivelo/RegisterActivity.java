package com.example.tryhu.navivelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        EditText nameText = (EditText) findViewById(R.id.nameText);
        EditText lastNameText = (EditText) findViewById(R.id.lastNameText);
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText emailText = (EditText) findViewById(R.id.emailText);
        EditText passwordRegisterText = (EditText) findViewById(R.id.passwordRegisterText);

        Button registerButton = (Button) findViewById(R.id.registerButton);



    }
}
