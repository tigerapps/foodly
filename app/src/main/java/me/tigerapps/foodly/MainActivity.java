package me.tigerapps.foodly;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import me.tigerapps.foodly.data.Recipe;
import me.tigerapps.foodly.databinding.MainActivityBinding;

public class MainActivity extends Activity {
    public static final String EXTRA_RECIPE = "recipe";

    private final MainActivityModel model = new MainActivityModel();

    public void viewRecipe(final Recipe recipe) {
        final Intent intent = new Intent(this, RecipeActivity.class);
        intent.putExtra(EXTRA_RECIPE, recipe.getId());
        startActivity(intent);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final MainActivityBinding binding =
                DataBindingUtil.setContentView(this, R.layout.main_activity);
        binding.setModel(model);
    }
}
