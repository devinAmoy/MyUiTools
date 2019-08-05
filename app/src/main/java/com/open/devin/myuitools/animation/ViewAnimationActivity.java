package com.open.devin.myuitools.animation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.open.devin.myuitools.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ViewAnimationActivity extends AppCompatActivity {

    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_view_animation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_alpha:
                doAnimation(getAlphaAnimation());
                break;
            case R.id.action_rotate:
                doAnimation(getRotateAnimation());
                break;
            case R.id.action_scale:
                doAnimation(getScaleAnimation());
                break;
            case R.id.action_translate:
                doAnimation(getTranslateAnimation());
                break;
            case R.id.action_set:
                doAnimation(getSetAnimation());
                break;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    private Animation getSetAnimation() {
        AnimationSet animationSet=new AnimationSet(true);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setStartOffset(100);
        animationSet.addAnimation(getRotateAnimation());
        animationSet.addAnimation(getScaleAnimation());
        animationSet.addAnimation(getTranslateAnimation());
        return animationSet;
    }

    private TranslateAnimation getTranslateAnimation() {
        TranslateAnimation translateAnimation=new TranslateAnimation(0,imageView.getWidth()*2,0,imageView.getHeight()*2);
        translateAnimation.setDuration(2000);
        translateAnimation.setRepeatCount(1);
        translateAnimation.setFillAfter(true);
        translateAnimation.setFillBefore(false);
        translateAnimation.setRepeatMode(Animation.REVERSE);
        return translateAnimation;
    }

    private ScaleAnimation getScaleAnimation() {
        ScaleAnimation animation = new ScaleAnimation(1f, 2f, 1f, 2f, imageView.getWidth() / 2, imageView.getHeight() / 2);
        animation.setRepeatCount(2);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setDuration(1000);
        animation.setFillAfter(true);
        animation.setFillBefore(false);//停留在最后一帧
        return animation;
    }

    private RotateAnimation getRotateAnimation() {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, imageView.getWidth() / 2, imageView.getHeight() / 2);
        rotateAnimation.setDuration(1000);
        rotateAnimation.setRepeatCount(2);
        rotateAnimation.setFillAfter(false);
        rotateAnimation.setFillBefore(true);//停留在第一帧
        rotateAnimation.setRepeatMode(Animation.REVERSE);
        return rotateAnimation;
    }

    private void doAnimation(Animation animation) {
        Animation oldAnimation = imageView.getAnimation();
        if (oldAnimation != null && (oldAnimation.hasStarted() || (!oldAnimation.hasEnded()))) {
            oldAnimation.cancel();
            imageView.clearAnimation();
        }

        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        imageView.startAnimation(animation);
    }

    private AlphaAnimation getAlphaAnimation() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1F, 0.2f);
        alphaAnimation.setDuration(2000);
        alphaAnimation.setRepeatCount(2);
        alphaAnimation.setFillAfter(false);
        alphaAnimation.setFillBefore(true);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        return alphaAnimation;
    }
}
