package com.example.zucheapplication.activity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.zucheapplication.R;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author bingyi
 * @description 驾驶证信息Activity
 * @return 两张驾驶证图片
 * @time 2021/7/1/0001 08:50
 */
public class LicenseActivity extends AppCompatActivity {

    private ImageView imageLicensePositive;
    private ImageView imageLicenseBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_license);
        imageLicensePositive = findViewById(R.id.image_license_positive);
        imageLicenseBack = findViewById(R.id.image_license_back);

        initImage();
    }

    /**
     * @description TODO 将驾驶证图片显示出来
     * @return 两张驾驶证信息
     * @author bingyi
     * @time 2021/7/1/0001 08:53
     */
    private void initImage(){

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}