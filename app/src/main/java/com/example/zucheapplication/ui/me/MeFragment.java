package com.example.zucheapplication.ui.me;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zucheapplication.R;
import com.example.zucheapplication.activity.LoginActivity;
import com.example.zucheapplication.activity.OrderActivity;
import com.example.zucheapplication.activity.UserInfoActivity;
import com.example.zucheapplication.util.Connect;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

/**
 * @author bingyi
 * @description 我的页面
 * @time 2021/6/30/0030 08:35
 */
public class MeFragment extends Fragment {

    /**
     * 用户头像
     */
    private ImageView meImageUserIcon;
    /**
     * 账号
     */
    private TextView meTxtUsername;
    /**
     * 余额
     */
    private TextView meTxtBalance;
    /**
     * 更多订单
     */
    private TextView meTxtOrderMore;
    /**
     * 已预约
     */
    private Button meBtnDating;
    /**
     * 进行中
     */
    private Button meBtnLoading;
    /**
     * 已结束
     */
    private Button meBtnFinish;
    /**
     * 加500
     */
    private Button meBtnBalanceAdd500;
    /**
     * 加100
     */
    private Button meBtnBalanceAdd100;
    /**
     * 加50
     */
    private Button meBtnBalanceAdd50;
    /**
     * 加20
     */
    private Button meBtnBalanceAdd20;
    /**
     * 关于我们
     */
    private TextView meTxtAboutOur;
    /**
     * 退出登录
     */
    private Button meBtnExit;
    /**
     * 用户信息界面
     */
    private ConstraintLayout constraintLayoutUserinfo;

    /**
     * 类型参数
     */
    public static final int DATING = 0x01;
    public static final int LOADING = 0x02;
    public static final int FINISH = 0x03;
    public static final int MORE = 0x04;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_me, container, false);

        meImageUserIcon = view.findViewById(R.id.me_image_user_icon);
        meTxtUsername = view.findViewById(R.id.me_txt_username);
        meTxtBalance = view.findViewById(R.id.me_txt_balance);
        meTxtOrderMore = view.findViewById(R.id.me_txt_order_more);
        meBtnDating = view.findViewById(R.id.me_btn_dating);
        meBtnLoading = view.findViewById(R.id.me_btn_loading);
        meBtnFinish = view.findViewById(R.id.me_btn_finish);
        meBtnBalanceAdd500 = view.findViewById(R.id.me_btn_balance_add500);
        meBtnBalanceAdd100 = view.findViewById(R.id.me_btn_balance_add100);
        meBtnBalanceAdd50 = view.findViewById(R.id.me_btn_balance_add50);
        meBtnBalanceAdd20 = view.findViewById(R.id.me_btn_balance_add20);
        meTxtAboutOur = view.findViewById(R.id.me_txt_about_our);
        meBtnExit = view.findViewById(R.id.me_btn_exit);
        constraintLayoutUserinfo = view.findViewById(R.id.constraintLayout_userinfo);

        click();
        return view;
    }

    /**
     * @description 点击事件
     * @author bingyi
     * @time 2021/6/30/0030 08:55
     */
    private void click() {
        @SuppressLint("NonConstantResourceId") View.OnClickListener listener = v -> {
            switch (v.getId()) {

                //已预约
                case R.id.me_btn_dating:
                    Intent toOrderDating = new Intent(getContext(), OrderActivity.class);
                    toOrderDating.putExtra("Type", DATING);
                    startActivity(toOrderDating);
                    break;

                //进行中
                case R.id.me_btn_loading:
                    Intent toOrderLoading = new Intent(getContext(), OrderActivity.class);
                    startActivity(toOrderLoading);
                    toOrderLoading.putExtra("Type", LOADING);
                    break;

                //已结束
                case R.id.me_btn_finish:
                    Intent toOrderFinish = new Intent(getContext(), OrderActivity.class);
                    startActivity(toOrderFinish);
                    toOrderFinish.putExtra("Type", FINISH);
                    break;

                //更多订单
                case R.id.me_txt_order_more:
                    Intent toOrderMore = new Intent(getContext(), OrderActivity.class);
                    toOrderMore.putExtra("Type", MORE);
                    startActivity(toOrderMore);
                    break;

                case R.id.me_btn_balance_add500:
                    Log.e("Me", "click: add500");
                    break;

                case R.id.me_btn_balance_add100:
                    Log.e("Me", "click: add100");
                    break;

                case R.id.me_btn_balance_add50:
                    Log.e("Me", "click: add50");
                    break;

                case R.id.me_btn_balance_add20:
                    Log.e("Me", "click: add20");
                    break;

                //关于我们
                case R.id.me_txt_about_our:
                    AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                    builder.setTitle("提示：")
                            .setMessage("联系我们？爱租不租！")
                            .setCancelable(true)
                            .show();
                    break;

                //跳转到登录页
                case R.id.me_btn_exit:
                    Intent toLogin = new Intent(getContext(), LoginActivity.class);
                    startActivity(toLogin);
                    Connect.HEADER = null;
                    requireActivity().finish();
                    break;

                default:
                    break;
            }
        };

        View.OnLongClickListener longClickListener = v -> {
            Intent toUserInfo = new Intent(getContext(), UserInfoActivity.class);
            startActivity(toUserInfo);
            return false;
        };

        meTxtOrderMore.setOnClickListener(listener);
        meBtnDating.setOnClickListener(listener);
        meBtnLoading.setOnClickListener(listener);
        meBtnFinish.setOnClickListener(listener);
        meBtnBalanceAdd500.setOnClickListener(listener);
        meBtnBalanceAdd100.setOnClickListener(listener);
        meBtnBalanceAdd50.setOnClickListener(listener);
        meBtnBalanceAdd20.setOnClickListener(listener);
        meTxtAboutOur.setOnClickListener(listener);
        meBtnExit.setOnClickListener(listener);

        //长按进入修改信息
        constraintLayoutUserinfo.setOnLongClickListener(longClickListener);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}