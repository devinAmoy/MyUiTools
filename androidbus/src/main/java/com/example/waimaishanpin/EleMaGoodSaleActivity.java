package com.example.waimaishanpin;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.leftsidemenu.R;
import com.uitools.mylibrary.router.RouterMap;

@Route(path = RouterMap.BOOK_DINNER)
public class EleMaGoodSaleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ele_ma_good_sale);
    }

    public void expendCut(View view) {
    }
}
