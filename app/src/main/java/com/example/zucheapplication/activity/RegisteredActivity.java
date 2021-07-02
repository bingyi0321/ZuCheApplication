package com.example.zucheapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zucheapplication.R;
import com.example.zucheapplication.entity.user.User;
import com.example.zucheapplication.util.Connect;
import com.google.gson.Gson;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

/**
 * @author bingyi
 * @description 注册页面
 * @time 2021/6/30/0030 09:10
 */
public class RegisteredActivity extends AppCompatActivity {

    /**
     * 用户头像
     */
    private ImageView imageUserIcon;
    /**
     * 账号
     */
    private EditText editUsername;
    /**
     * 密码
     */
    private EditText editPassword;
    /**
     * 姓名
     */
    private EditText editName;
    /**
     * 性别
     */
    private TextView txtSex;
    /**
     * 电话
     */
    private EditText editPhone;
    /**
     * 注册
     */
    private Button btnRegisteredAdd;
    /**
     * 跳转登录
     */
    private Button btnLoginInto;

    /**
     * 性别选择项
     */
    private int chedkedItem = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        imageUserIcon = findViewById(R.id.image_user_icon);
        editUsername = findViewById(R.id.edit_username);
        editPassword = findViewById(R.id.edit_password);
        editName = findViewById(R.id.edit_name);
        txtSex = findViewById(R.id.txt_sex);
        editPhone = findViewById(R.id.edit_phone);
        btnRegisteredAdd = findViewById(R.id.btn_registered_add);
        btnLoginInto = findViewById(R.id.btn_login_into);

        click();
    }

    /**
     * @param
     * @return null
     * @description 初始化界面
     * @author bingyi
     * @time 2021/6/28/0028 10:26
     */
    private void click() {
        //注册
        btnRegisteredAdd.setOnClickListener(v -> {
            //TODO 调用发送到后端 开线程
            Connect.executor.execute(() -> {
                String username = editUsername.getText().toString();
                String password = editPassword.getText().toString();
                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();

                if (!"".equals(username) && !"".equals(password) && !"".equals(name)
                        && !"".equals(phone)) {
                    User user = new User(username, password, name, phone, chedkedItem, "");
                    Log.e("test", "user:" + user.toString());
                    Gson gson = new Gson();
                    String json = gson.toJson(user);
                    //TODO 接口换成注册的
                    Connect.postDataNoHead(Connect.URL + "/user/login", json);
                    SystemClock.sleep(500);
                    Intent toLogin = new Intent(this, LoginActivity.class);
                    startActivity(toLogin);
                } else {
                    Toast.makeText(this, "请输入信息进行注册", Toast.LENGTH_SHORT).show();
                }
            });
        });

        //跳转到登录
        btnLoginInto.setOnClickListener(v -> {
            Intent toLogin = new Intent(this, LoginActivity.class);
            startActivity(toLogin);
        });

        //选择性别
        txtSex.setOnClickListener(v -> {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("请选择性别：");
            final String[] cities = {"男", "女"};
            alert.setSingleChoiceItems(cities, chedkedItem, (dialog, which) -> {
                chedkedItem = which;
            });
            alert.setNegativeButton("确认", (dialog, which) -> {
                txtSex.setText(cities[chedkedItem]);
                dialog.dismiss();
            });
            alert.setPositiveButton("取消", (dialog, which) -> dialog.dismiss());
            AlertDialog dialog = alert.create();
            dialog.show();

        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}