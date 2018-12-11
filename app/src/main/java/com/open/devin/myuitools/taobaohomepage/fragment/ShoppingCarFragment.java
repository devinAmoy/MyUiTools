package com.open.devin.myuitools.taobaohomepage.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open.devin.myuitools.R;

/**
 * Created by devinc on 2018/12/5.
 */
public class ShoppingCarFragment extends Fragment {
    private static ShoppingCarFragment instance = new ShoppingCarFragment();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_car, container, false);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Fragment getInstance() {
        Bundle args = new Bundle();
        instance.setArguments(args);
        return instance;
    }
}
