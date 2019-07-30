package com.open.devin.myuitools.animation;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class AnimationListFragment extends ListFragment {
    public static AnimationListFragment newInstance() {
        AnimationListFragment fragment = new AnimationListFragment();
        return fragment;
    }

    ArrayAdapter<String> arrayAdapter;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] array = new String[]{
                "视图动画",//0
                "帧动画",//1
                "属性动画",//2
        };
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, array);
        setListAdapter(arrayAdapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent();
        switch (position) {
            case 0:
                intent = new Intent(getContext(), ViewAnimationActivity.class);
                break;
            case 1:
                intent = new Intent(getContext(), DrawableAnimationActivity.class);
                break;
            case 2:
                intent = new Intent(getContext(), PropertyAnimationActivity.class);
                break;
            default:
                break;
        }

        startActivity(intent);
    }
}
