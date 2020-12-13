package com.lagou.domain;

import java.util.Date;
import java.util.Objects;

/**
 * @Author jacob
 * @Date 2020/12/12 23:21
 * @Version 1.0
 */
public class User {
    private String userId;
    private String userName;
    private String passWord;
    private String gender;
    private Date birthday;

    public User() {
    }

    public User(String userId, String userName, String passWord, String gender, Date birthday) {
        this.userId = userId;
        this.userName = userName;
        this.passWord = passWord;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
