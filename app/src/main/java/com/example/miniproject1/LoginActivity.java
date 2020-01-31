package com.example.miniproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    int count =5;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username =findViewById(R.id.username);
        password =findViewById(R.id.password);
        login =findViewById(R.id.login);
        textView =findViewById(R.id.textattempt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String USERNAME = username.getText().toString();
                String PASSWORD = password.getText().toString();
                if(USERNAME.equals("admin")&& PASSWORD.equals("123")) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);

                    startActivity(intent);
                }else{
                    count--;
                    Toast.makeText(LoginActivity.this, String.valueOf(count)+"Wrong username & password", Toast.LENGTH_SHORT).show();
                    textView.setText("Attempt Left: " + String.valueOf(count));
                    if(count==0){
                        login.setEnabled(false);
                    }

                }

            }
        });

    }
}
