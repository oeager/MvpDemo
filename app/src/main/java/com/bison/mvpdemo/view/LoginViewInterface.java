package com.bison.mvpdemo.view;

/**
 * Created by oeager on 2015/8/12 0012.
 * email: oeager@foxmail.com
 */
public interface LoginViewInterface {
    String getUserName();

    String getPassword();

    void showProgress();

    void dismissProgress();

    void showLoginFail(String error);

    void goToActivity();
}
