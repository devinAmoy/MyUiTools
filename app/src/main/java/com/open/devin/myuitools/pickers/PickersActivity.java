package com.open.devin.myuitools.pickers;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.open.devin.myuitools.R;

public class PickersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pickers);
    }

    public void onNestView(View view) {
        startActivity(new Intent(this, NestActivity.class));
    }
}
