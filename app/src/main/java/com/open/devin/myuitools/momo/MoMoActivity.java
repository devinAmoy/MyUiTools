package com.open.devin.myuitools.momo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.open.devin.myuitools.R;
import com.uitools.mylibrary.router.RouterMap;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = RouterMap.MO_MO_ACTIVITY)
public class MoMoActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_mo);
        ButterKnife.bind(this);

        MoMoAdapter moMoAdapter = new MoMoAdapter(this);
        rv.setAdapter(moMoAdapter);
        rv.setLayoutManager(new SwipeCardLayoutManger(this));

        List<SwipeCardView> list = new ArrayList<>();
        int i = 1;
        list.add(new SwipeCardView(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155117_8i4Rk.thumb.700_0.jpeg", "美女1"));
        list.add(new SwipeCardView(i++, "http://cdnq.duitang.com/uploads/item/201505/04/20150504155014_irFvu.thumb.700_0.jpeg", "美女2"));
        list.add(new SwipeCardView(i++, "http://img5q.duitang.com/uploads/item/201309/17/20130917032356_hdGjF.thumb.700_0.jpeg", "美女3"));
        list.add(new SwipeCardView(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155137_JWcRK.thumb.700_0.jpeg", "美女4"));
        list.add(new SwipeCardView(i++, "http://img5q.duitang.com/uploads/item/201505/04/20150504155036_zNrPT.thumb.700_0.jpeg", "美女5"));
        list.add(new SwipeCardView(i++, "http://img5q.duitang.com/uploads/item/201504/26/201504262026_weMcT.thumb.700_0.jpeg", "美女6"));
        list.add(new SwipeCardView(i++, "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1560164210849&di=c6ea3fdd3ec938600ddde9022f46033c&imgtype=0&src=http%3A%2F%2Fbbs-fd.zol-img.com.cn%2Ft_s800x5000%2Fg4%2FM09%2F00%2F07%2FCg-4WlJA9zCIPZ8PAAQWAhRW0ssAAMA8wD2hYAABBYa996.jpg", "美女7"));
        list.add(new SwipeCardView(i++, "http://imgq.duitang.com/uploads/item/201504/21/20150421H2323_uwdEs.jpeg", "美女8"));

        moMoAdapter.setData(list);

        SwipCallBack callBack = new SwipCallBack(moMoAdapter, rv, moMoAdapter.getData());
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callBack);
        itemTouchHelper.attachToRecyclerView(rv);
    }
}
