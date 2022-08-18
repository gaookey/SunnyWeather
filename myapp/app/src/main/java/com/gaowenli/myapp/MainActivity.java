package com.gaowenli.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gaowenli.myapp.activity.BaseActivity;
import com.gaowenli.myapp.activity.LoginActivity;
import com.gaowenli.myapp.activity.RegisterActivity;

public class MainActivity extends BaseActivity {

    private Button loginBtn;
    private Button registerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginBtn = findViewById(R.id.btn_login);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               navigateTo(LoginActivity.class);
            }
        });

        registerBtn = findViewById(R.id.btn_register);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               navigateTo(RegisterActivity.class);
            }
        });
    }
}