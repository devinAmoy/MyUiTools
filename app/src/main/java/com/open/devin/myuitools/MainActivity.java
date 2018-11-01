package com.open.devin.myuitools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.open.devin.myuitools.pickers.PickersActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.picker).setOnClickListener(v -> startActivity(new Intent(this, PickersActivity.class)));
    }
}