package com.example.zucheapplication.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zucheapplication.R;

import androidx.appcompat.app.AppCompatActivity;


/**
 * @author bingyi
 * @description 用户信息Activity
 * @time 2021/6/29/0029 10:37
 */
public class UserInfoActivity extends AppCompatActivity {

    private ImageView userinfoImageUserIcon;
    private TextView userinfoTxtUsername;
    private TextView userinfoTxtName;
    private TextView userinfoTxtSex;
    private TextView userinfoTxtPhone;
    private TextView userinfoTxtLicense;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        userinfoImageUserIcon = findViewById(R.id.userinfo_image_user_icon);
        userinfoTxtUsername = findViewById(R.id.userinfo_txt_username);
        userinfoTxtName = findViewById(R.id.userinfo_txt_name);
        userinfoTxtSex = findViewById(R.id.userinfo_txt_sex);
        userinfoTxtPhone = findViewById(R.id.userinfo_txt_phone);
        userinfoTxtLicense = findViewById(R.id.userinfo_txt_license);
        click();
    }

    /**
     * @return 响应事件
     * @description 界面点击事件
     * @author bingyi
     * @time 2021/6/29/0029 10:41
     */
    private void click() {
        @SuppressLint("NonConstantResourceId") View.OnClickListener listener = v -> {
            switch (v.getId()) {

                //头像框
                case R.id.userinfo_image_user_icon:
                    //TODO 点击头像打开相册选择图片
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle("更换头像")
                            .setMessage("请选择图片方式：")
                            .setNegativeButton("打开相机", (dialog, which) -> {
                                startActivity(new Intent(UserInfoActivity.this,
                                        CameraActivity.class).putExtra(CameraActivity.ExtraType,
                                        CameraActivity.CAMERA));
                            })
                            .setNeutralButton("从相册选择", (dialog, which) -> {
                                startActivity(new Intent(UserInfoActivity.this,
                                        CameraActivity.class).putExtra(CameraActivity.ExtraType,
                                        CameraActivity.PHOTO));
                            })
                            .setCancelable(true)
                            .show();
                    break;

                case R.id.userinfo_txt_license:
                    //TODO 查询是否已认证驾驶证 是就跳转 否则提示是否认证
                    Intent toLicense = new Intent(this, LicenseActivity.class);
                    startActivity(toLicense);
                    break;

                default:
                    break;
            }
        };

        //监听设置
        userinfoImageUserIcon.setOnClickListener(listener);
        userinfoTxtUsername.setOnClickListener(listener);
        userinfoTxtName.setOnClickListener(listener);
        userinfoTxtSex.setOnClickListener(listener);
        userinfoTxtPhone.setOnClickListener(listener);
        userinfoTxtLicense.setOnClickListener(listener);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}