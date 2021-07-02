package com.example.zucheapplication.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.zucheapplication.R;

import static android.content.ContentValues.TAG;

/**
 * @description 预约页面
 * @return
 * @author bingyi
 * @time 2021/6/30/0030 09:54
 */
public class DateActivity extends AppCompatActivity {

    private TextView dataTxtCarPlate;
    private TextView dataTxtCarBrand;
    private TextView dataTxtCarType;
    private Button dataBtnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        dataTxtCarType = findViewById(R.id.date_txt_car_type);
        dataTxtCarPlate = findViewById(R.id.date_txt_car_plate);
        dataTxtCarBrand = findViewById(R.id.date_txt_car_brand);
        dataBtnSubmit = findViewById(R.id.date_btn_submit);

        click();
    }

    /**
     * @description 点击事件
     * @return null
     * @author bingyi
     * @time 2021/6/30/0030 10:32
     */
    private void click(){
        dataBtnSubmit.setOnClickListener(v -> {
            Log.e(TAG, "DataActivity click" );
        });
    }
}