package com.open.devin.myuitools.leftsidemenustyles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.open.devin.myuitools.R;

public class LeftSideMenuHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_left_side_menu_home);
    }

    public void style1(View view) {
        startActivity(new Intent(this, SideMenuStyle1Activity.class));
    }


}
