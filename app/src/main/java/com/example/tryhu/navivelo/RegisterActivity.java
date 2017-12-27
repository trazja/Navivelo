package com.example.tryhu.navivelo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);

        EditText nameText = (EditText) findViewById(R.id.nameText);
        EditText lastNameText = (EditText) findViewById(R.id.lastNameText);
        EditText userName = (EditText) findViewById(R.id.userName);
        EditText emailText = (EditText) findViewById(R.id.emailText);
       final EditText passwordRegisterText = (EditText) findViewById(R.id.passwordRegisterText);
       final EditText confirmPassword = (EditText) findViewById(R.id.confirmPassword);

        Button registerButton = (Button) findViewById(R.id.registerButton);


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordRegisterText.equals(confirmPassword)){

                    Toast.makeText(RegisterActivity.this, R.string.registration_ok, Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(RegisterActivity.this, R.string.passwords_not_equal, Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
