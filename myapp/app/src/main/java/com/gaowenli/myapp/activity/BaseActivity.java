package com.gaowenli.myapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.gaowenli.myapp.MainActivity;

public class BaseActivity extends AppCompatActivity {
    public Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = this;
    }

    public void showToast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
    }

    public void navigateTo(Class cls) {
        Intent intent = new Intent(mContext, cls);
        startActivity(intent);
    }
}