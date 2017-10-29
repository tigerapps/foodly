package me.tigerapps.foodly;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.tigerapps.foodly.data.User;
import me.tigerapps.foodly.databinding.WelcomeFragment2Binding;

public class WelcomeFragment2 extends Fragment {
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final WelcomeFragment2Binding binding =
                WelcomeFragment2Binding.inflate(inflater, container, false);
        binding.setUser(new User(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        return binding.getRoot();
    }
}
