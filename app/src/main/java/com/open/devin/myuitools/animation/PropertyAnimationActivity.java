package com.open.devin.myuitools.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.open.devin.myuitools.R;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PropertyAnimationActivity extends AppCompatActivity {

    @BindView(R.id.text_view)
    TextView textView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreatePanelMenu(int featureId, Menu menu) {
        getMenuInflater().inflate(R.menu.menu_property, menu);
        return super.onCreatePanelMenu(featureId, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemId = item.getItemId();
        switch (itemId) {
            case R.id.action_do_byxml:
                getAnimationFromXml().start();
                break;
            case R.id.action_bycode:
                getAnimatorFromCode().start();
                break;
            case R.id.action_bycustom:

                break;
            case R.id.action_byviewpropertyanimator:
                break;
            case R.id.action_bylayoutanimator:
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private Animator getAnimatorFromCode() {
        AnimatorSet animatorSet = new AnimatorSet();

        PropertyValuesHolder backgroundColor = PropertyValuesHolder.ofObject("backgroundColor", new ArgbEvaluator(), 0xff009688, 0xff795548);
        PropertyValuesHolder rotateX = PropertyValuesHolder.ofFloat("rotationX", 0, 360F);

        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, backgroundColor, rotateX);
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(1);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);

        final int height = textView.getHeight();
        final int width = textView.getWidth();

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(1f, 3f);
        valueAnimator.setRepeatCount(1);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setDuration(2000);

        valueAnimator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            textView.getLayoutParams().width = (int) (value * width);
            textView.getLayoutParams().height = (int) (value * height);
            textView.requestLayout();
        });
        animatorSet.playTogether(objectAnimator, valueAnimator);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());

        return animatorSet;
    }

    private Animator getAnimationFromXml() {
        final int height = textView.getHeight();
        final int width = textView.getWidth();
        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this, R.animator.propertyanimator);

        ArrayList<Animator> childAnimations = animatorSet.getChildAnimations();
        ValueAnimator valueAnimator = (ValueAnimator) childAnimations.get(childAnimations.size() - 1);
        valueAnimator.addUpdateListener(animation -> {
            float animatedValue = (float) valueAnimator.getAnimatedValue();
            textView.getLayoutParams().height = (int) (height * animatedValue);
            textView.getLayoutParams().width = (int) (width * animatedValue);
            textView.requestLayout();
        });
        animatorSet.setTarget(textView);

        return animatorSet;
    }
}
