package com.bison.mvpdemo.model;

/**
 * Created by oeager on 2015/8/12 0012.
 * email: oeager@foxmail.com
 */
public class LoginInfo {
    private String userName;
    private String passWord;


    public LoginInfo(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
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
}
