package com.example.leftsidemenu.leftsidemenustyles;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.leftsidemenu.R;
import com.example.leftsidemenu.R2;
import com.google.android.material.navigation.NavigationView;
import com.uitools.mylibrary.router.RouterMap;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = RouterMap.SIDE_MENU_STYLE1)
public class SideMenuStyle1Activity extends AppCompatActivity {


    @BindView(R2.id.toolbar)
    Toolbar toolbar;
    @BindView(R2.id.footer_item_setting)
    Button footerItemSetting;
    @BindView(R2.id.footer_item_out)
    Button footerItemOut;
    @BindView(R2.id.navigation_view)
    NavigationView navigationView;
    @BindView(R2.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu_style1);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, 0, 0);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        View headerView = navigationView.getHeaderView(0);

    }
}
