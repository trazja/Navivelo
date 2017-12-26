package com.example.tryhu.navivelo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        EditText login = (EditText) findViewById(R.id.login);
        EditText loginPassword = (EditText) findViewById(R.id.loginPassword);
        TextView registerLink = (TextView) findViewById(R.id.registerLink);

        Button loginButton = (Button) findViewById(R.id.loginButton);


        //dodanie napisu "Zarejestruj się" jako aktywnego linku, który przekierwouje do okna logowania

        registerLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
                LoginActivity.this.startActivity(registerIntent);

            }

});
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                
                Toast.makeText(LoginActivity.this, R.string.login_correct, Toast.LENGTH_SHORT).show();


                Toast.makeText(LoginActivity.this, R.string.login_incorrect, Toast.LENGTH_SHORT).show();


            }
        });
    }
}
