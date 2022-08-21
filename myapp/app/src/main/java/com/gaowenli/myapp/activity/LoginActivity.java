package com.gaowenli.myapp.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.gaowenli.myapp.R;
import com.gaowenli.myapp.api.Api;
import com.gaowenli.myapp.api.ApiConfig;
import com.gaowenli.myapp.api.GoCallback;
import com.gaowenli.myapp.entity.LoginResponse;
import com.gaowenli.myapp.util.AppConfig;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class LoginActivity extends BaseActivity {

    private EditText editAccount;
    private EditText editPwd;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editAccount = findViewById(R.id.account);
        editPwd = findViewById(R.id.pwd);
        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account = editAccount.getText().toString().trim();
                String pwd = editPwd.getText().toString().trim();

                login(account, pwd);
            }
        });
    }

    private void login(String account, String pwd) {

        navigateTo(HomeActivity.class);

        /*
        if (account == null || account.length() <= 0) {
            showToast("请输入账号"); // 13612345678
            return;
        }
        if (pwd == null || pwd.length() <= 0) {
            showToast("请输入密码"); // admin
            return;
        }

        HashMap<String, Object> m = new HashMap();
        m.put("phone", account);
        m.put("password", pwd);
        Api.config(ApiConfig.LOGIN, m).postRequest(new GoCallback() {
            @Override
            public void onSuccess(String res) {
                showToast(res);

                Gson gson = new Gson();
                LoginResponse response = gson.fromJson(res, LoginResponse.class);
                if (response.getCode() == 0) {
                    String token = response.getToken();
                    SharedPreferences sp = getSharedPreferences("sp_go", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("token", token);
                    editor.commit();

                    navigateTo(HomeActivity.class);
                    showToast("登陆成功");
                } else {
                    showToast("登陆失败");
                }
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
        */
    }
}