package com.open.devin.myuitools;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.open.devin.myuitools.taobaohomepage.TaoBaoHomePageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startModule(R.id.tao_bao, TaoBaoHomePageActivity.class);
    }

    private void startModule(int id, Class activity) {
        findViewById(id).setOnClickListener(v -> startActivity(new Intent(this, activity)));
    }
}
