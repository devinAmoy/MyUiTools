package com.open.devin.myuitools;

import android.os.Bundle;

import com.uitools.mylibrary.BaseActivity;
import com.uitools.mylibrary.router.RouterMap;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startModule(R.id.left_side_menu, RouterMap.LEFT_SIDE_MENU_HOME);
        startModule(R.id.mo_mo, RouterMap.MO_MO_ACTIVITY);
        startModule(R.id.animation, RouterMap.ANIMATION_DEMO);
        startModule(R.id.xx_news, RouterMap.XX_NEWS_MAIN);
    }

    private void startModule(int id, String moduleName) {
        findViewById(id).setOnClickListener(v -> navigation(moduleName));
    }
}
