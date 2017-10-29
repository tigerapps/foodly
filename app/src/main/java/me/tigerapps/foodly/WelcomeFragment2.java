package me.tigerapps.foodly;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.tigerapps.foodly.data.User;
import me.tigerapps.foodly.databinding.WelcomeFragment2Binding;

public class WelcomeFragment2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final WelcomeFragment2Binding binding =
                DataBindingUtil.inflate(inflater, R.layout.welcome_fragment2, container, false);
        binding.setUser(new User(PreferenceManager.getDefaultSharedPreferences(getActivity())));
        return binding.getRoot();
    }
}
