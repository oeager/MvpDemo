package com.bison.mvpdemo.view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bison.mvpdemo.R;
import com.bison.mvpdemo.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements LoginViewInterface {

    private EditText userNameEdit;
    private EditText pwdEdit;
    private ProgressDialog dialog;

    private LoginPresenter loginPresenter = new LoginPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {

        userNameEdit = (EditText) findViewById(R.id.userName);
        pwdEdit = (EditText) findViewById(R.id.passWord);
    }

    public void onAction(View v){
        loginPresenter.login();
    }


    @Override
    public String getUserName() {
        return userNameEdit.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return pwdEdit.getText().toString().trim();
    }

    @Override
    public void showProgress() {
        if(dialog==null){
            dialog = ProgressDialog.show(this,"","loading...");
        }else{
            if(!dialog.isShowing()){
                dialog.show();
            }
        }
    }

    @Override
    public void dismissProgress() {
        if(dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }
    }

    @Override
    public void showLoginFail(final String error) {
       runOnUiThread(new Runnable() {
           @Override
           public void run() {
               Toast.makeText(LoginActivity.this, error, Toast.LENGTH_SHORT).show();
           }
       });

    }

    @Override
    public void goToActivity() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(LoginActivity.this, "登录成功,跳转HomeActivity", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
