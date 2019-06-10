package com.open.devin.myuitools.leftsidemenustyles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;

import com.open.devin.myuitools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SideMenuStyle1Activity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.footer_item_setting)
    Button footerItemSetting;
    @BindView(R.id.footer_item_out)
    Button footerItemOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_menu_style1);
        ButterKnife.bind(this);
    }
}
