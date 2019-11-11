package com.example.slidingoptions;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.leftsidemenu.R;
import com.uitools.mylibrary.router.RouterMap;

@Route(path = RouterMap.SLIDE_OPTIONS)
public class SlidingOptionsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_options);
    }
}
