package com.example.leftsidemenu.leftsidemenustyles;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.leftsidemenu.R;
import com.example.leftsidemenu.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SideMenuStyle2Activity extends AppCompatActivity {


    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.content_frame_layout)
    FrameLayout contentFrameLayout;
    @BindView(R2.id.iv_head)
    AppCompatImageView ivHead;
    @BindView(R2.id.cl_head_view)
    ConstraintLayout clHeadView;
    @BindView(R2.id.msg_bg)
    TextView msgBg;
    @BindView(R2.id.ll_android)
    LinearLayout llAndroid;
    @BindView(R2.id.ll_apple)
    LinearLayout llApple;
    @BindView(R2.id.menu_frame_layout)
    FrameLayout menuFrameLayout;
    @BindView(R2.id.drawerLayout)
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
