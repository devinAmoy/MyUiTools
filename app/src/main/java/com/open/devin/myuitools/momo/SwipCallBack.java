package com.open.devin.myuitools.momo;

import android.graphics.Canvas;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.List;

public class SwipCallBack extends ItemTouchHelper.SimpleCallback {
    private MoMoAdapter moMoAdapter;
    private RecyclerView rv;
    private List<SwipeCardView> data;


    public SwipCallBack(MoMoAdapter moMoAdapter, RecyclerView rv, List<SwipeCardView> data) {
        super(0, 15);//1111
        this.moMoAdapter = moMoAdapter;

        this.rv = rv;
        this.data = data;
    }


    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        SwipeCardView remove = data.remove(viewHolder.getLayoutPosition());
        data.add(0, remove);
        moMoAdapter.notifyDataSetChanged();
    }

    @Override
    public void onChildDraw(@NonNull Canvas c, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
        super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);


    }

    @Override
    public long getAnimationDuration(@NonNull RecyclerView recyclerView, int animationType, float animateDx, float animateDy) {
        return 1000;
    }

    @Override
    public float getSwipeThreshold(@NonNull RecyclerView.ViewHolder viewHolder) {
        return 0.2f;
    }

}
