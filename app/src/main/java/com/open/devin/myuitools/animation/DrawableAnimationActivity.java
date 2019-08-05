package com.open.devin.myuitools.animation;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.open.devin.myuitools.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrawableAnimationActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_on_off, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_start:
                doAnimation(getAnimationDrawable(false), true);
                break;
            case R.id.action_stop:
                doAnimation(getAnimationDrawable(true), false);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private AnimationDrawable getAnimationDrawable(boolean isFromXml) {
        if (isFromXml) {
            AnimationDrawable animationDrawable = (AnimationDrawable) imageView.getDrawable();
            return animationDrawable;
        } else {
            AnimationDrawable animation = new AnimationDrawable();
            for (int i = 1; i < 8; i++) {
                int drawableId = getResources().getIdentifier("run" + i, "drawable", getPackageName());
                Drawable drawable = getDrawable(drawableId);
                if (drawable!=null){
                    animation.addFrame(drawable, 100);
                }
                imageView.setImageDrawable(animation);
            }
            return animation;
        }
    }

    private void doAnimation(AnimationDrawable animationDrawable, boolean isDo) {
        if (animationDrawable.isRunning()) {
            animationDrawable.stop();
        }

        if (isDo) {
            animationDrawable.start();
        }
    }
}
