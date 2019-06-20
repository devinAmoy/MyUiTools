package com.open.devin.myuitools.momo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.open.devin.myuitools.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoMoActivity extends AppCompatActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mo_mo);
        ButterKnife.bind(this);


    }
}
