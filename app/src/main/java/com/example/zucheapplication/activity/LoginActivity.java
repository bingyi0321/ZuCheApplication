package com.example.zucheapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.example.zucheapplication.R;
import com.example.zucheapplication.entity.user.User;
import com.example.zucheapplication.util.Connect;
import com.google.gson.Gson;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

/**
 * @author bingyi
 * @description 登录Activity
 * @time 2021/6/30/0030 09:07
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * 登录
     */
    private Button btnLogin;
    /**
     * 注册
     */
    private Button btnRegistered;
    /**
     * 账号
     */
    private AppCompatEditText txtUsername;
    /**
     * 密码
     */
    private AppCompatEditText txtPassword;

    private Connect connect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btn_login);
        btnRegistered = findViewById(R.id.btn_registered);
        txtUsername = findViewById(R.id.txt_username);
        txtPassword = findViewById(R.id.txt_password);
        click();
    }

    /**
     * @return null
     * @description 初始化界面及登录
     * @author bingyi
     * @time 2021/6/28/0028 10:11
     */
    private void click() {

        //登录
        btnLogin.setOnClickListener(v -> {
            String username = Objects.requireNonNull(txtUsername.getText()).toString();
            String password = Objects.requireNonNull(txtPassword.getText()).toString();
            if (!"".equals(username) && !"".equals(password)) {
                User user = new User();
                user.setUserName(username);
                user.setPassword(password);
                Gson gson = new Gson();
                String json = gson.toJson(user);
                Connect.postDataNoHead(Connect.URL + "/user/login", json);
                SystemClock.sleep(500);
                Connect.HEADER = JSONObject.parseObject(Connect.RESULT).getJSONObject("data").getString("token");
                Log.e("Login", "token: " + Connect.HEADER);

                Intent toMain = new Intent(this, MainActivity.class);
                startActivity(toMain);

                finish();
            } else {
                Toast.makeText(this, "请输入账号密码进行登录", Toast.LENGTH_SHORT).show();
            }

        });

        //注册
        btnRegistered.setOnClickListener(v -> {
            Intent toRegistered = new Intent(this, RegisteredActivity.class);
            startActivity(toRegistered);
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}