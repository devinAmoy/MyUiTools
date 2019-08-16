package com.open.devin.myuitools.leftsidemenustyles;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.open.devin.myuitools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SideMenuStyle2Activity extends AppCompatActivity {

    @BindView(R.id.view_statusbar)
    View viewStatusbar;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.content_frame_layout)
    FrameLayout contentFrameLayout;
    @BindView(R.id.iv_head)
    AppCompatImageView ivHead;
    @BindView(R.id.cl_head_view)
    ConstraintLayout clHeadView;
    @BindView(R.id.msg_bg)
    TextView msgBg;
    @BindView(R.id.ll_android)
    LinearLayout llAndroid;
    @BindView(R.id.ll_apple)
    LinearLayout llApple;
    @BindView(R.id.menu_frame_layout)
    FrameLayout menuFrameLayout;
    @BindView(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu_style2);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                contentFrameLayout.setTranslationX(menuFrameLayout.getWidth());
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {
                contentFrameLayout.setTranslationX(0);
            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });
    }
}
