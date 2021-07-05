package com.example.zucheapplication.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.zucheapplication.R;
import com.example.zucheapplication.activity.SearchActivity;
import com.example.zucheapplication.entity.car.Car;
import com.example.zucheapplication.entity.car.CarInfoItemAdapter;
import com.example.zucheapplication.util.Connect;
import com.example.zucheapplication.util.GlideImageLoader;
import com.google.gson.Gson;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * @author bingyi
 * @description 主页面
 * @return
 * @time 2021/6/30/0030 09:04
 */
public class HomeFragment extends Fragment {

    /**
     * 搜索框
     */
    private TextView txtSearch;
    /**
     * 车辆信息
     */
    private RecyclerView recyclerViewCarInfo;
    /**
     * 轮播图
     */
    private Banner homeBanner;

    private CarInfoItemAdapter carInfoItemAdapter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        txtSearch = view.findViewById(R.id.txt_search);
        recyclerViewCarInfo = view.findViewById(R.id.recyclerView_car_info);
        homeBanner = view.findViewById(R.id.home_banner);


        initList();

        click();
        initBanner();

        return view;
    }

    /**
     * @description 点击界面事件
     * @author bingyi
     * @time 2021/6/29/0029 09:07
     */
    private void click() {
        txtSearch.setOnClickListener(v -> {
            Intent intent = new Intent(getContext(), SearchActivity.class);
            startActivity(intent);
        });
    }

    /**
     * @description 轮播图
     * @author bingyi
     * @time 2021/6/29/0029 10:58
     */
    private void initBanner() {
        //设置图片加载器
        homeBanner.setImageLoader(new GlideImageLoader());
        homeBanner.setImages(Connect.image);
        homeBanner.setDelayTime(3000);
        homeBanner.start();
        /*home_banner.setOnBannerListener(v -> {
            Intent intent = new Intent(getContext(), PromotionActivity.class);
            startActivity(intent);
        });*/
    }

    /**
     * @return 车辆信息列表
     * @description 初始化列表
     * @author bingyi
     * @time 2021/7/2/0002 11:34
     */
    private void initList() {
        //TODO 测试从JSON数组获取数据

        Connect.getData(Connect.URL + "/car/all");
        //耗时操作需给延时
        SystemClock.sleep(1000);
        JSONObject jsonObject = JSONObject.parseObject(Connect.RESULT);

        JSONArray array = jsonObject.getJSONArray("data");
        for (int i = 0; i < array.size(); i++) {
            JSONObject object = array.getJSONObject(i);
            int id = object.getInteger("carId");
            String carImage = object.getString("carImage");
            String carPlate = object.getString("carPlate");
            String carBrand = object.getString("carBrand");
            String carType = object.getString("carType");
            double price = object.getDouble("price");
            int seating = object.getInteger("seating");
            int status = object.getInteger("status");
            Log.e("TAG", "initList: 获得id:" + id + " 车牌:" + carPlate + "\n 车辆品牌:"
                    + carBrand + " 车辆类型:" + carType + " image:" + carImage);

            Connect.cars.add(new Car(id, carPlate, carBrand, carType, price, carImage, status));
            Connect.image.add(Uri.parse(carImage));
        }


        carInfoItemAdapter = new CarInfoItemAdapter(Connect.cars);
        recyclerViewCarInfo.setAdapter(carInfoItemAdapter);
        recyclerViewCarInfo.setLayoutManager(new LinearLayoutManager(getContext()));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}