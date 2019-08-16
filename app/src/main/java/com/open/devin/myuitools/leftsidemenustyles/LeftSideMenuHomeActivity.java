package com.open.devin.myuitools.leftsidemenustyles;

import android.os.Bundle;
import android.view.View;

import com.open.devin.myuitools.R;
import com.uitools.mylibrary.BaseActivity;

public class LeftSideMenuHomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_side_menu_home);
    }

    public void style1(View view) {
        startActivity(SideMenuStyle1Activity.class);
    }

    public void style2(View view){
        startActivity(SideMenuStyle2Activity.class);
    }

}
