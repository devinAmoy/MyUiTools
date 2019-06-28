package com.open.devin.myuitools.momo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;

public class SwipeCardLayoutManger extends RecyclerView.LayoutManager {

    private static float SCALE_GAP = 0.05f;
    private static int TRANS_Y_GAP;
    public static int MAX_SHOW_COUNT = 4;


    public SwipeCardLayoutManger(Context context) {
        TRANS_Y_GAP = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 15, context.getResources().getDisplayMetrics());
    }

    @Override
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        detachAndScrapAttachedViews(recycler);

        int itemCount = getItemCount();
        int bottomPosition;

        if (itemCount < MAX_SHOW_COUNT) {
            bottomPosition = 0;
        } else {
            bottomPosition = itemCount - 4;
        }

        for (int i = bottomPosition; i < itemCount; i++) {
            View view = recycler.getViewForPosition(i);
            addView(view);
            measureChildWithMargins(view, 0, 0);

            int width = getWidth() - getDecoratedMeasuredWidth(view);
            int height = getHeight() - getDecoratedMeasuredHeight(view);

            layoutDecoratedWithMargins(view,
                    width / 2,
                    height / 2,
                    width / 2 + getDecoratedMeasuredWidth(view),
                    height / 2 + getDecoratedMeasuredHeight(view));

            int level = itemCount - i - 1;
            if (level > 0) {
                if (level < MAX_SHOW_COUNT - 1) {
                    view.setTranslationY(TRANS_Y_GAP * level);
                    view.setScaleX(1 - SCALE_GAP * level);
                    view.setScaleY(1 - SCALE_GAP * level);
                } else {
                    view.setTranslationY(TRANS_Y_GAP * (level-1));
                    view.setScaleX(1 - SCALE_GAP * (level-1));
                    view.setScaleY(1 - SCALE_GAP * (level-1));
                }
            }

        }
    }
}
