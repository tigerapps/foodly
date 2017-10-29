package me.tigerapps.foodly;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.tigerapps.foodly.data.User;
import me.tigerapps.foodly.databinding.WelcomeFragment3Binding;

public class WelcomeFragment3 extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final WelcomeFragment3Binding binding =
                WelcomeFragment3Binding.inflate(inflater, container, false);
        binding.setUser(new User(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        return binding.getRoot();
    }
}
