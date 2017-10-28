package me.tigerapps.foodly;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.main_activity);
    }
}
