package com.example.zucheapplication.util;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.zucheapplication.entity.car.Car;

import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static android.content.ContentValues.TAG;

/**
 * @author bingyi
 * @ClassName Connect
 * @Description 连接网络及后台
 * email 1005196988@qq.com
 * on 2021/6/29/0029 10:59
 */
public class Connect {

    /**
     * 地址
     */
    public static String URL = "http://10.0.2.2:8081";

    /**
     * 路径
     */
    public static String PATH;

    /**
     * 请求头
     */
    public static String HEADER;

    /**
     * 图片数组
     */
    public static List<Uri> image = new ArrayList<>();

    /**
     * 车辆信息
     */
    public static List<Car> cars = new ArrayList<>();

    /**
     * 线程池
     */
    public static ExecutorService executor = new ThreadPoolExecutor(10,
            10, 60L, TimeUnit.SECONDS,
            new ArrayBlockingQueue(10));


    /**
     * 设置okhttp
     */
    private static OkHttpClient client = new OkHttpClient();
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public Connect() {

    }

    static {
        //TODO 需要转换为json文件
        /*int size = 5;
        for (int i = 1; i < size; i++) {
            image.add(Uri.parse("https://my-link.oss-cn-shenzhen.aliyuncs.com/MyAndroidImage/home" + i + ".jpg"));
        }*/


    }

    /**
     * @param url 完整路径
     * @return json文件转换的字符串
     * @description 连接后台获取数据
     * @author bingyi
     * @time 2021/7/1/0001 09:33
     * String path="http://192.168.43.227:8080/demo_android/login.action?username="+name+"&password="+password;
     */
    public static void getData(String url) {
        executor.execute(() -> {
            final Request request = new Request.Builder()
                    .addHeader("Authorization", HEADER).url(url).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response)
                        throws IOException {
                    RESULT = Objects.requireNonNull(response.body()).string();
                    Log.e(TAG, "RESULT:" + RESULT);
                }
            });
        });
    }


    /**
     * 存放结果
     */
    public static String RESULT;

    /**
     * @param url 完整路径
     * @return RESULT 字符串
     * @description 发送数据到后台 不带请求头的
     * @author bingyi
     * @time 2021/7/1/0001 09:34
     */
    public static void postDataNoHead(String url, String json) {
        executor.execute(() -> {
            RequestBody requestBody = RequestBody.create(JSON, json);
            final Request request = new Request.Builder().url(url).post(requestBody).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response)
                        throws IOException {
                    RESULT = Objects.requireNonNull(response.body()).string();
                }
            });
        });
    }

    /**
     * @param url 完整路径
     * @return RESULT 字符串
     * @description 发送数据到后台 带请求头的
     * @author bingyi
     * @time 2021/7/1/0001 09:34
     */
    public static void postDataHasHead(String url, String json) {
        executor.execute(() -> {
            RequestBody requestBody = RequestBody.create(JSON, json);
            final Request request = new Request.Builder()
                    .addHeader("Authorization", HEADER).url(url).post(requestBody).build();
            client.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(@NotNull Call call, @NotNull IOException e) {
                }

                @Override
                public void onResponse(@NotNull Call call, @NotNull Response response)
                        throws IOException {
                    RESULT = Objects.requireNonNull(response.body()).string();
                    //TODO 测试位完成
                    Log.e(TAG, "RESULT:" + RESULT);
                }
            });
        });
    }


    //TODO 测试图片上传

    private String Path = "https://10.url.cn/eth/ajNVdqHZLLAxibwnrOxXSzIxA76ichutwMCcOpA45xjiapneMZsib7eY4wUxF6XDmL2FmZEVYsf86iaw/";
    private static final int SUCCESS = 200;
    private static final int FALL = 500;
    Handler handler = new Handler() {
        @SuppressLint("HandlerLeak")
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
//加载网络成功,进行UI的更新,处理得到的图片资源
                case SUCCESS:
//通过message,拿到字节数组
                    byte[] Picture = (byte[]) msg.obj;
//使用BitmapFactory工厂,把字节数组转换为bitmap
                    Bitmap bitmap = BitmapFactory.decodeByteArray(Picture, 0, Picture.length);
//通过ImageView,设置图片
                    //mImageView_okhttp.setImageBitmap(bitmap);
                    break;
//当加载网络失败,执行的逻辑代码
                case FALL:
                    Log.e(TAG, "网络异常");
                    break;
                default:
                    break;
            }
        }
    };

    /**
     * 根据点击事件获取络上的图片资源,使用的是OKhttp框架
     *
     * @param view 布局
     */
    public void Picture_okhttp_bt(View view) {
//1. 创建OKhttpClient对象
        OkHttpClient okHttpClient = new OkHttpClient();
//2.建立Request对象,设置参数,请求方式如果是get,就不用设置,默认使用的就是get
        Request request = new Request.Builder()
                //设置请求网址
                .url(Path)
                //建立request对象
                .build();
//3.创建一个Call对象,参数是request对象,发送请求
        Call call = okHttpClient.newCall(request);
//4.异步请求,请求加入调度
        call.enqueue(new Callback() {
            @Override//请求失败回调
            public void onFailure(Call call, IOException e) {
                handler.sendEmptyMessage(FALL);
            }

            @Override//请求成功回调
            public void onResponse(Call call, Response response) throws IOException {
//得到从网上获取资源,转换成我们想要的类型
                byte[] Picture_bt = response.body().bytes();
//通过handler更新UI
                Message message = handler.obtainMessage();
                message.obj = Picture_bt;
                message.what = SUCCESS;
                handler.sendMessage(message);
            }
        });
    }
    //当按钮点击时,执行使用OKhttp上传图片到服务器(http://blog.csdn.net/tangxl2008008/article/details/51777355)
//注意:有时候上传图片失败,是服务器规定还要上传一个Key,如果开发中关于网络这一块出现问题,就多和面试官沟通沟通

    /**
     * @return null
     * @description 上传图片
     * @author bingyi
     * @time 2021/7/2/0002 08:32
     */
    public void uploading(View view) {
//图片上传接口地址
        String url = "https://www.718shop.com/sell/sell.m.picture.upload.do";
//创建上传文件对象
        File file = new File(Environment.getExternalStorageDirectory(), "big.jpg");
//创建RequestBody封装参数
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/octet-stream"), file);
//创建MultipartBody,给RequestBody进行设置
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("image", "big.jpg", fileBody)
                .build();
//创建Request
        Request request = new Request.Builder()
                .url(url)
                .post(multipartBody)
                .build();
//创建okhttp对象
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .build();
//上传完图片,得到服务器反馈数据
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e("ff", "uploadMultiFile() e=" + e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.i("ff", "uploadMultiFile() response=" + response.body().string());
            }
        });
    }
    //TODO 测试结束

}
