package com.sadieyu.myweixin;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
    private EditText mUser; // 帐号编辑框
    private EditText mPassword; // 密码编辑框

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        mUser = (EditText)findViewById(R.id.login_user_edit);
        mPassword = (EditText)findViewById(R.id.login_passwd_edit);

    }

    public void login_mainweixin(View v) {
        if("hello".equals(mUser.getText().toString()) && "world".equals(mPassword.getText().toString()))   //判断 帐号和密码
        {
            Intent intent = new Intent();
            intent.setClass(Login.this,LoadingActivity.class);
            startActivity(intent);
        }
        else if("".equals(mUser.getText().toString()) || "".equals(mPassword.getText().toString()))   //判断 帐号和密码
        {
            new AlertDialog.Builder(Login.this)
                    .setIcon(getResources().getDrawable(R.drawable.login_error_icon))
                    .setTitle(getString(R.string.txt_login_failed))
                    .setMessage(getString(R.string.txt_dialog_alert_message))
                    .create().show();
        }
        else{

            new AlertDialog.Builder(Login.this)
                    .setIcon(getResources().getDrawable(R.drawable.login_error_icon))
                    .setTitle(getString(R.string.txt_login_error))
                    .setMessage(getString(R.string.txt_count_not_exist))
                    .create().show();
        }

        //登录按钮
    	/*
      	Intent intent = new Intent();
		intent.setClass(Login.this,Whatsnew.class);
		startActivity(intent);
		Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
		this.finish();*/
    }
    public void login_back(View v) {     //标题栏 返回按钮
        this.finish();
    }
    public void login_pw(View v) {     //忘记密码按钮
        Uri uri = Uri.parse("http://3g.qq.com");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
        //Intent intent = new Intent();
        //intent.setClass(Login.this,Whatsnew.class);
        //startActivity(intent);
    }
}
