package com.bison.mvpdemo.model;

import com.bison.mvpdemo.presenter.LoginPresenter;

/**
 * Created by oeager on 2015/8/12 0012.
 * email: oeager@foxmail.com
 */
public interface LoginModelInterface {

    void login(String userName,String password,LoginPresenter.CallBack callBack);
}
