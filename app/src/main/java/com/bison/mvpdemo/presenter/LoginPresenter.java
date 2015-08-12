package com.bison.mvpdemo.presenter;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.bison.mvpdemo.model.LoginBusinessImp;
import com.bison.mvpdemo.model.LoginInfo;
import com.bison.mvpdemo.model.LoginModelInterface;
import com.bison.mvpdemo.view.LoginViewInterface;

/**
 * Created by oeager on 2015/8/12 0012.
 * email: oeager@foxmail.com
 */
public class LoginPresenter {

    private final LoginModelInterface loginBusiness;

    private final LoginViewInterface loginViewInterface;

    public LoginPresenter(LoginViewInterface viewInterface){
        this.loginBusiness = new LoginBusinessImp();
        this.loginViewInterface = viewInterface;
    }

    public void login(){
        String userName = loginViewInterface.getUserName();
        String password  = loginViewInterface.getPassword();
        if(TextUtils.isEmpty(userName)||TextUtils.isEmpty(password)){
            loginViewInterface.showLoginFail("请完善登录信息");
            return;
        }
        loginViewInterface.showProgress();
        loginBusiness.login(userName, password, new CallBack() {
            @Override
            public void onSuccess(LoginInfo info) {
                loginViewInterface.dismissProgress();
                loginViewInterface.goToActivity();
            }

            @Override
            public void onFail(final Throwable error) {
                loginViewInterface.dismissProgress();
                loginViewInterface.showLoginFail(error.getMessage());
            }
        });
    }

    public interface CallBack{

        void onSuccess(LoginInfo info);

        void onFail(Throwable error);
    }
}
