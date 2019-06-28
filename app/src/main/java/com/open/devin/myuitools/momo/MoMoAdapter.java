package com.open.devin.myuitools.momo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.open.devin.myuitools.R;

import java.util.ArrayList;
import java.util.List;

public class MoMoAdapter extends RecyclerView.Adapter<CardViewHolder> {

    List<SwipeCardView> cardViews = new ArrayList<>();
    private Context context;

    public MoMoAdapter(Context context){

        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mo_mo_item, null);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder cardViewHolder, int i) {
        SwipeCardView swipeCardView = cardViews.get(i);
        Glide.with(context).load(swipeCardView.url).into(cardViewHolder.imageView);
        cardViewHolder.indexTextView.setText(i+"/"+getItemCount());
        cardViewHolder.textView.setText("Girl"+i);
    }

    @Override
    public int getItemCount() {
        return cardViews.size();
    }


    public void setData(List<SwipeCardView> list) {
        this.cardViews=list;
        notifyDataSetChanged();
    }
}
