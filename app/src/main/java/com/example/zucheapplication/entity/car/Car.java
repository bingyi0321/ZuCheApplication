package com.example.zucheapplication.entity.car;

/**
 * @author bingyi
 * email 1005196988@qq.com
 * Created by bingyi on 2021/6/28/0028 15:15
 * @ClassName Car
 * @Description 车辆类
 */
public class Car {

    /**
     * 车辆id
     */
    private int car_id;
    /**
     * 车牌
     */
    private String car_plate;
    /**
     * 品牌
     */
    private String car_brand;
    /**
     * 类型
     */
    private String car_type;
    /**
     * 单价
     */
    private double price;
    /**
     * 图片
     */
    private String car_image;
    /**
     * 车辆状态
     */
    private int status;


    /**
     * @return 构造函数
     * @description 车辆构造函数（全参数）
     * @author bingyi
     * @time 2021/6/28/0028 15:27
     */
    public Car(int car_id, String car_plate, String car_brand, String car_type, double price,
               String car_image, int status) {
        this.car_id = car_id;
        this.car_plate = car_plate;
        this.car_brand = car_brand;
        this.car_type = car_type;
        this.price = price;
        this.car_image = car_image;
        this.status = status;
    }

    public Car() {
    }

    public int getCar_id() {
        return car_id;
    }

    public void setCar_id(int car_id) {
        this.car_id = car_id;
    }

    public String getCar_plate() {
        return car_plate;
    }

    public void setCar_plate(String car_plate) {
        this.car_plate = car_plate;
    }

    public String getCar_brand() {
        return car_brand;
    }

    public void setCar_brand(String car_brand) {
        this.car_brand = car_brand;
    }

    public String getCar_type() {
        return car_type;
    }

    public void setCar_type(String car_type) {
        this.car_type = car_type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCar_image() {
        return car_image;
    }

    public void setCar_image(String car_image) {
        this.car_image = car_image;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
