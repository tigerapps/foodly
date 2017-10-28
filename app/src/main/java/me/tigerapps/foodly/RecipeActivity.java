package me.tigerapps.foodly;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.tigerapps.foodly.data.Recipe;
import me.tigerapps.foodly.databinding.RecipeActivityBinding;

public class RecipeActivity extends Activity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DataBindingUtil.setContentView(this, R.layout.recipe_activity);
    }
}
