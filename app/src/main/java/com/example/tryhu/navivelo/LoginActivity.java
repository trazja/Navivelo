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

        final EditText userName = (EditText) findViewById(R.id.login);
        final EditText userPassword = (EditText) findViewById(R.id.loginPassword);
        final TextView registerLink = (TextView) findViewById(R.id.registerLink);

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

                final String login = userName.getText().toString();
                final String password = userPassword.getText().toString();

                //na razie zrobiłam tylko takiego if'a, żeby w ogóle dało radę się zalogować - nie bardzo wiem, w jaki sposób zrobić tutaj
                //bazę użytkowników

                if (login.equals("admin") && password.equals("admin")) {

                    Toast.makeText(LoginActivity.this, R.string.login_correct, Toast.LENGTH_SHORT).show();

                    //jak dodać przejście do kolejnego view?
                    Intent registerIntent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(registerIntent);


                } else {

                    Toast.makeText(LoginActivity.this, R.string.login_incorrect, Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
