package com.example.zucheapplication.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.zucheapplication.R;

/**
 * @description 订单页面
 * @return
 * @author bingyi
 * @time 2021/6/30/0030 09:43
 */
public class OrderActivity extends AppCompatActivity {

    private RecyclerView orderRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        orderRecyclerView = findViewById(R.id.order_recyclerView);

        
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}