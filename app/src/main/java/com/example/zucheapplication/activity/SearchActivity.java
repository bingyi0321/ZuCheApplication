package com.example.zucheapplication.activity;

import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.zucheapplication.R;
import com.example.zucheapplication.entity.car.Car;
import com.example.zucheapplication.entity.car.CarInfoItemAdapter;
import com.example.zucheapplication.util.Connect;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static android.content.ContentValues.TAG;

/**
 * @author bingyi
 * @description 搜索Activity
 * @time 2021/6/29/0029 09:17
 */
public class SearchActivity extends AppCompatActivity {

    private EditText editSearchPlate;
    private EditText editSearchBrand;
    private Button btnSearchGet;
    private RecyclerView recyclerView;
    private List<Car> carList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        editSearchPlate = findViewById(R.id.edit_search_plate);
        editSearchBrand = findViewById(R.id.edit_search_brand);
        btnSearchGet = findViewById(R.id.btn_search_get);
        recyclerView = findViewById(R.id.recyclerView_car_list);


        searchInfo();
    }

    /**
     * @return 搜索结果
     * @description 查找车辆信息
     * @author bingyi
     * @time 2021/6/29/0029 11:35
     */
    private void searchInfo() {
        //点击获取
        btnSearchGet.setOnClickListener(v -> {
            String plate = editSearchPlate.getText().toString();
            String brand = editSearchBrand.getText().toString();
            editSearchPlate.clearFocus();

            Car car = new Car();
            car.setCar_plate(plate);
            car.setCar_brand(brand);
            Gson gson = new Gson();
            String json = gson.toJson(car);
            Log.e(TAG, "Car" + json);
            //TODO 接口查询
            //Connect.getData(Connect.URL + "/user/login", json);
        });
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}