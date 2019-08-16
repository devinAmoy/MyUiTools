package com.uitools.mylibrary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {
    public void startActivity(Class<?> cls){
        startActivity(new Intent(this, cls));
    }
}
