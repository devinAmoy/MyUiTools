package com.open.devin.myuitools.taobaohomepage.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by devinc on 2018/12/5.
 */
public class MeFragment extends Fragment {

    private static MeFragment instance = new MeFragment();

    public static Fragment getInstance() {
        Bundle args = new Bundle();
        instance.setArguments(args);
        return instance;
    }
}
