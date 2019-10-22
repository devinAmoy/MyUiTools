package com.open.devin.myuitools.animation;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.open.devin.myuitools.R;
import com.uitools.mylibrary.router.RouterMap;

@Route(path = RouterMap.ANIMATION_DEMO)
public class AnimationDemoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation_demo);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frameLayout, AnimationListFragment.newInstance(), AnimationListFragment.class.getName());
        fragmentTransaction.commit();
    }
}
