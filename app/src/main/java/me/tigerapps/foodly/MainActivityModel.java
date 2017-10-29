package me.tigerapps.foodly;

import android.databinding.BaseObservable;

import java.util.Random;

import me.tigerapps.foodly.bindings.ObservableSortedMap;
import me.tigerapps.foodly.bindings.ObservableTreeMap;
import me.tigerapps.foodly.data.Recipe;

public class MainActivityModel extends BaseObservable {
    private final ObservableSortedMap<String, Recipe> thisWeeksRecipes = new ObservableTreeMap<>();

    public ObservableSortedMap<String, Recipe> getThisWeeksRecipes() {
        return thisWeeksRecipes;
    }

    public Recipe recommendRecipe() {
        if (thisWeeksRecipes.size() < 1)
            return null;
        final int selection = new Random().nextInt(thisWeeksRecipes.size());
        int i = 0;
        for (final Recipe recipe : thisWeeksRecipes.values())
            if (i++ == selection)
                return recipe;
        return null;
    }
}
