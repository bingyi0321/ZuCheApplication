package com.example.zucheapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zucheapplication.R;
import com.youth.banner.Banner;

import static android.content.ContentValues.TAG;

/**
 * @description 车辆详情页
 * @return
 * @author bingyi
 * @time 2021/6/30/0030 09:54
 */
public class CarInfoActivity extends AppCompatActivity {

    private Banner carInfoBanner;
    private TextView carInfoTxtCarPlate;
    private TextView carInfoTxtCarBrand;
    private TextView carInfoTxtCarType;
    private TextView carInfoTxtCarSeating;
    private TextView carInfoTxtCarPrice;
    private Button carInfoBtnAddDate;
    private Button carInfoBtnAddOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_info);
        carInfoBanner = findViewById(R.id.car_info_banner);
        carInfoTxtCarPlate = findViewById(R.id.car_info_txt_car_plate);
        carInfoTxtCarBrand = findViewById(R.id.car_info_txt_car_brand);
        carInfoTxtCarType = findViewById(R.id.car_info_txt_car_type);
        carInfoTxtCarSeating = findViewById(R.id.car_info_txt_car_seating);
        carInfoTxtCarPrice = findViewById(R.id.car_info_txt_car_price);
        carInfoBtnAddDate = findViewById(R.id.car_info_btn_add_date);
        carInfoBtnAddOrder = findViewById(R.id.car_info_btn_add_order);

        click();
    }

    /**
     * @description 点击事件
     * @return null
     * @author bingyi
     * @time 2021/6/30/0030 11:11
     */
    private void click(){
        //预约
        carInfoBtnAddDate.setOnClickListener(v -> {
            Intent toDate = new Intent(this,DateActivity.class);
            startActivity(toDate);
        });

        //直接下单
        carInfoBtnAddOrder.setOnClickListener(v -> {
            Log.e(TAG, "click: addOrder" );
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}