package com.uitools.xiangxuenews.databindingtest;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.uitools.mylibrary.router.RouterMap;
import com.uitools.xiangxuenews.R;
import com.uitools.xiangxuenews.databinding.ActivityDataBindingTestBinding;

@Route(path = RouterMap.XX_DATABINDING_TEST)
public class DataBindingTestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDataBindingTestBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding_test);
        final User user = new User("aaa", "bbb");
        binding.setUser(null);
        final EditText editText = binding.getRoot().findViewById(R.id.first_name_edt);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                user.setFirstName(editText.getText().toString());
                return false;
            }
        });
    }
}
