package com.example.leftsidemenu.leftsidemenustyles;

import android.os.Bundle;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.leftsidemenu.R;
import com.uitools.mylibrary.BaseActivity;
import com.uitools.mylibrary.router.RouterMap;

@Route(path = RouterMap.LEFT_SIDE_MENU_HOME)
public class LeftSideMenuHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_side_menu_home);
    }

    public void style1(View view) {
        navigation(RouterMap.SIDE_MENU_STYLE1);
    }

    public void style2(View view){
        startActivity(SideMenuStyle2Activity.class);
    }

}
