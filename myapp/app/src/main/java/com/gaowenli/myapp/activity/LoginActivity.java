package com.gaowenli.myapp.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;

import com.gaowenli.myapp.R;
import com.gaowenli.myapp.util.AppConfig;

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
        if (account == null || account.length() <= 0) {
            showToast("请输入账号"); // 13612345678
            return;
        }
        if (pwd == null || pwd.length() <= 0) {
            showToast("请输入密码"); // admin
            return;
        }

        OkHttpClient client = new OkHttpClient.Builder().build();

        Map m = new HashMap();
        m.put("phone", account);
        m.put("password", pwd);

        JSONObject jsonObject = new JSONObject(m);
        String jsonString = jsonObject.toString();

        RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonString);

        Request request = new Request.Builder()
                .url(AppConfig.BASE_URL + "/app/login")
                .addHeader("contentType", "application/json;charset=utf-8")
                .post(requestBody)
                .build();

        final Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                Log.e("onFailure", e.getMessage());
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                String result = response.body().string();
                Log.e("onResponse", result);
            }
        });
    }
}