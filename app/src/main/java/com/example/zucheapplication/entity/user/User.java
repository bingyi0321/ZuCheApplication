package com.example.zucheapplication.entity.user;

import org.jetbrains.annotations.NotNull;

/**
 * @author bingyi
 * @ClassName User
 * @Description 用户类
 * email 1005196988@qq.com
 * Created by bingyi on 2021/6/28/0028 15:48
 */
public class User {

    /**
     * id
     */
    private int userId;
    /**
     * 账号
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 性别
     */
    private int sex;
    /**
     * 头像
     */
    private String imageurl;
    /**
     * 是否提交押金
     */
    private int deposit;
    /**
     * 驾照认证
     */
    private int license;

    /**
     * @return 构造函数
     * @description 用户构造函数（全参数）
     * @author bingyi
     * @time 2021/6/28/0028 15:53
     */
    public User(int userId, String username, String password, String phone, int sex,
                String imageurl, int deposit, int license) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.sex = sex;
        this.imageurl = imageurl;
        this.deposit = deposit;
        this.license = license;
    }

    /**
     * @return 构造函数
     * @description 注册用
     * @author bingyi
     * @time 2021/7/2/0002 08:48
     * @param imageurl 返回回来的图片路径
     */
    public User(String username, String password, String name, String phone, int sex, String imageurl) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.sex = sex;
        this.imageurl = imageurl;
    }

    /**
     * @return null
     * @description 无参构造函数
     * @author bingyi
     * @time 2021/7/1/0001 10:46
     */
    public User() {
    }

    @NotNull
    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", sex=" + sex +
                ", imageurl='" + imageurl + '\'' +
                ", deposit=" + deposit +
                ", license=" + license +
                '}';
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }
}
