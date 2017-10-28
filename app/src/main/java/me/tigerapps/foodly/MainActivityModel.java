package me.tigerapps.foodly;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

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
        final int index = new Random().nextInt(thisWeeksRecipes.size());
        int i = 0;
        for (final Recipe recipe : thisWeeksRecipes.values())
            if (i++ == index)
                return recipe;
        return null;
    }
}
