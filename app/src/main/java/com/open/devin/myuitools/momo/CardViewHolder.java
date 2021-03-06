package com.open.devin.myuitools.momo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.open.devin.myuitools.R;

public class CardViewHolder extends RecyclerView.ViewHolder {
    public ImageView imageView;
    public TextView textView;
    public TextView indexTextView;

    public CardViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.iv);
        textView = itemView.findViewById(R.id.name);
        indexTextView = itemView.findViewById(R.id.tvPrecent);
    }
}
