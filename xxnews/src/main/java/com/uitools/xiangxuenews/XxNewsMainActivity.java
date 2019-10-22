package com.uitools.xiangxuenews;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.uitools.mylibrary.router.RouterMap;

@Route(path = RouterMap.XX_NEWS_MAIN)
public class XxNewsMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xx_news_main);
    }
}
