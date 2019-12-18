package com.example.menudrage;


import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.leftsidemenu.R;
import com.example.leftsidemenu.R2;
import com.uitools.mylibrary.router.RouterMap;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = RouterMap.MENU_DRAG)
public class MenuDragActivity extends AppCompatActivity {

    @BindView(R2.id.tv_item_cate_name)
    TextView tvItemCateName;
    @BindView(R2.id.tv_drag_tip)
    TextView tvDragTip;
    @BindView(R2.id.drag_grid_view)
    DragGridView dragGridView;

    private DragViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_drag);
        ButterKnife.bind(this);

        adapter = new DragViewAdapter(this);
        dragGridView.setAdapter(adapter);
    }
}
