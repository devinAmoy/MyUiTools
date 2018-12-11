package com.open.devin.myuitools.taobaohomepage;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.open.devin.myuitools.taobaohomepage.fragment.HomeFragment;
import com.open.devin.myuitools.taobaohomepage.fragment.MeFragment;
import com.open.devin.myuitools.taobaohomepage.fragment.QuestionFragment;
import com.open.devin.myuitools.taobaohomepage.fragment.ShoppingCarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devinc on 2018/12/5.
 */
public class HomeViewPageAdapter extends FragmentPagerAdapter {
    private List<Fragment> pages = new ArrayList<>();

    public HomeViewPageAdapter(FragmentManager fm) {
        super(fm);
        pages.add(HomeFragment.getInstance());
        pages.add(QuestionFragment.getInstance());
        pages.add(ShoppingCarFragment.getInstance());
        pages.add(MeFragment.getInstance());
    }


    @Override
    public Fragment getItem(int i) {
        return pages.get(i);
    }

    @Override
    public int getCount() {
        return pages.size();
    }

}
