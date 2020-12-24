package com.itwn.entity;

public class User {
    private int id;
    private String userName;
    private String userPass;
    private String userPhone;
    private String userImg;
    private int userType;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userImg='" + userImg + '\'' +
                ", userType='" + userType + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public User(int id, String userName, String userPass, String userPhone, String userImg, int userType) {
        this.id = id;
        this.userName = userName;
        this.userPass = userPass;
        this.userPhone = userPhone;
        this.userImg = userImg;
        this.userType = userType;
    }

    public User() {
    }
}
