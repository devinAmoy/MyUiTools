package com.open.devin.myuitools.taobaohomepage.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by devinc on 2018/12/5.
 */
public class HomeFragment extends Fragment {
    private static final HomeFragment instance = new HomeFragment();
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    public static Fragment getInstance() {
        Bundle args = new Bundle();
        instance.setArguments(args);
        return instance;
    }
}
