package com.example.menudrage;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class DragGridView extends GridView {
    private int lastX = -1;
    private int lastY = -1;
    private boolean isDrag = false;
    private boolean isSwap = false;

    private View dragView;
    private BitmapDrawable hoverCell;
    private Rect currentRect;

    private int currentPosition = INVALID_POSITION;


    public DragGridView(Context context) {
        super(context);
    }

    public DragGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DragGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        int x = (int) ev.getX();
        int y = (int) ev.getY();

        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                if (isDrag) {
                    int offsetX = x - lastX;
                    int offsetY = y - lastY;

                    lastX = x;
                    lastY = y;

                    currentRect.offset(offsetX, offsetY);
                    if (hoverCell != null) {
                        hoverCell.setBounds(currentRect);
                    }

                    invalidate();

                    if (!isSwap) {
                        swapItem(x, y);
                    }

                    return false;
                }
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isDrag) {
                    endDrag();
                }
                break;
        }

        return super.onTouchEvent(ev);
    }

    private void swapItem(int x, int y) {
        int endPosition = pointToPosition(x, y);

        if (endPosition != INVALID_POSITION && endPosition != currentPosition) {
            isSwap = true;
            List<Animator> animators = new ArrayList<>();
            if (endPosition < currentPosition) {
                for (int i = endPosition; i <= currentPosition; i++) {
                    View view = getChildAt(i - getFirstVisiblePosition());
                    if (i % getNumColumns() == 0) {
                        animators.add(createTranslationAnimator(view, view.getWidth() * (getNumColumns() - 1), 0, -view.getHeight(), 0));
                    } else {
                        animators.add(createTranslationAnimator(view, -view.getWidth(), 0, 0, 0));
                    }
                }
            } else {
                for (int i = currentPosition; i < endPosition; i++) {
                    View view = getChildAt(i - getFirstVisiblePosition());
                    if ((i + 1) % getNumColumns() == 0) {
                        animators.add(createTranslationAnimator(view, -view.getWidth() * (getNumColumns() - 1), 0, view.getHeight(), 0));
                    } else {
                        animators.add(createTranslationAnimator(view, view.getWidth(), 0, 0, 0));
                    }
                }
            }

            ((SwapItemInterface)getAdapter()).swapItem(currentPosition, endPosition);
            currentPosition = endPosition;

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(animators);
            animatorSet.setDuration(300);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    dragView.setVisibility(VISIBLE);
                    dragView = getChildAt(currentPosition - getFirstVisiblePosition());
                    dragView.setVisibility(INVISIBLE);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    isSwap = false;
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });

            animatorSet.start();

        }
    }

    private Animator createTranslationAnimator(View view, float startX, float endX, float startY, float endY) {
        ObjectAnimator animatorX = ObjectAnimator.ofFloat(view, "translationX", startX, endX);
        ObjectAnimator animatorY = ObjectAnimator.ofFloat(view, "translationY", startY, endY);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(animatorX, animatorY);
        return animatorSet;
    }

    private void endDrag() {
        isDrag = false;
        dragView.setVisibility(VISIBLE);
        hoverCell = null;
    }

    public void beginDrag(int position) {
        if (position == INVALID_POSITION) {
            return;
        }

        dragView = getChildAt(position - getFirstVisiblePosition());
        if (dragView != null) {
            isDrag = true;

            hoverCell = getHoverCell(dragView);
            dragView.setVisibility(INVISIBLE);

            currentPosition = position;
        }

    }

    private BitmapDrawable getHoverCell(View dragView) {
        Bitmap bitmap = Bitmap.createBitmap(dragView.getWidth(), dragView.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        dragView.draw(canvas);

        BitmapDrawable bitmapDrawable = new BitmapDrawable(getResources(), bitmap);
        currentRect = new Rect(dragView.getLeft() - 20, dragView.getTop() - 20,
                dragView.getRight() - 20, dragView.getBottom() - 20);
        bitmapDrawable.setBounds(currentRect);
        return bitmapDrawable;
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (hoverCell != null) {
            hoverCell.draw(canvas);
        }
    }
}
