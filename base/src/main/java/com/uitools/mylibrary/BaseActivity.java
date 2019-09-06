package com.uitools.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class<?> cls){
        startActivity(new Intent(this, cls));
    }

    public void navigation(String path){
        ARouter.getInstance().build(path).navigation();
    }
}
