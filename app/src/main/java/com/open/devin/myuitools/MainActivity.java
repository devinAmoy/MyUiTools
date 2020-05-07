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
        startModule(R.id.dataBinding, RouterMap.XX_DATABINDING_TEST);
        startModule(R.id.sliding_options, RouterMap.SLIDE_OPTIONS);
        startModule(R.id.drag_manage, RouterMap.MENU_DRAG);
        startModule(R.id.elema_book_dinner, RouterMap.BOOK_DINNER);

    }

    private void startModule(int id, String moduleName) {
        findViewById(id).setOnClickListener(v -> navigation(moduleName));
    }
}
