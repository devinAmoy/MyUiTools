package com.open.devin.myuitools.taobaohomepage;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.open.devin.myuitools.R;
import com.open.devin.myuitools.taobaohomepage.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TaoBaoHomePageActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, ViewPager.OnPageChangeListener {

    @BindView(R.id.bottom_navigation_view)
    BottomNavigationView bottomNavigationView;

    @BindView(R.id.content_view_pager)
    ViewPager viewPager;

    private HomeViewPageAdapter viewPageAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tao_bao_home_page);
        ButterKnife.bind(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);

        viewPageAdapter = new HomeViewPageAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPageAdapter);
        viewPager.addOnPageChangeListener(this);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.home_page:
                viewPager.setCurrentItem(0);
                break;
            case R.id.question_page:
                viewPager.setCurrentItem(1);
                break;
            case R.id.shopping_cart_page:
                viewPager.setCurrentItem(2);
                break;
            case R.id.my_page:
                viewPager.setCurrentItem(3);
                break;
                default:
        }
        return true;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {
    }

    @Override
    public void onPageSelected(int i) {
        bottomNavigationView.getMenu().getItem(i).setCheckable(true);
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
