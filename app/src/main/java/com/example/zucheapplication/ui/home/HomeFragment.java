package com.example.zucheapplication.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zucheapplication.R;
import com.example.zucheapplication.activity.SearchActivity;
import com.example.zucheapplication.util.Connect;
import com.example.zucheapplication.util.GlideImageLoader;
import com.youth.banner.Banner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
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
    private TextView txt_search;
    /**
     * 车辆信息
     */
    private RecyclerView recyclerView_car_info;
    /**
     * 轮播图
     */
    private Banner home_banner;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        txt_search = view.findViewById(R.id.txt_search);
        recyclerView_car_info = view.findViewById(R.id.recyclerView_car_info);
        home_banner = view.findViewById(R.id.home_banner);


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
        txt_search.setOnClickListener(v -> {
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
        home_banner.setImageLoader(new GlideImageLoader());
        home_banner.setImages(Connect.image);
        home_banner.setDelayTime(3000);
        home_banner.start();
        /*home_banner.setOnBannerListener(v -> {
            Intent intent = new Intent(getContext(), PromotionActivity.class);
            startActivity(intent);
        });*/
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}