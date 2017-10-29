package me.tigerapps.foodly;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;

import me.tigerapps.foodly.databinding.WelcomeActivityBinding;

public class WelcomeActivity extends Activity {
    public static final String APP_PROVISIONED = "app_provisioned";

    private Fragment getNextFragment(final Fragment currentFragment) {
        if (currentFragment instanceof WelcomeFragment1)
            return new WelcomeFragment2();
        else if (currentFragment instanceof WelcomeFragment2)
            return new WelcomeFragment3();
        else if (currentFragment instanceof WelcomeFragment3)
            return new WelcomeFragment4();
        else
            return null;
    }

    private Fragment getPreviousFragment(final Fragment currentFragment) {
        if (currentFragment instanceof WelcomeFragment4)
            return new WelcomeFragment3();
        else if (currentFragment instanceof WelcomeFragment3)
            return new WelcomeFragment2();
        else if (currentFragment instanceof WelcomeFragment2)
            return new WelcomeFragment1();
        else
            return null;
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final WelcomeActivityBinding binding =
                DataBindingUtil.setContentView(this, R.layout.welcome_activity);
        binding.setActivity(this);
        final Fragment fragment = getFragmentManager().findFragmentById(R.id.fragment_container);
        if (fragment == null) {
            final FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.add(R.id.fragment_container, new WelcomeFragment1()).commit();
        }
    }

    public void onNavigateBackward(final View view) {
        if (getFragmentManager().getBackStackEntryCount() > 0)
            getFragmentManager().popBackStack();
    }

    public void onNavigateForward(final View view) {
        final FragmentManager fm = getFragmentManager();
        final Fragment currentFragment = fm.findFragmentById(R.id.fragment_container);
        final Fragment nextFragment = getNextFragment(currentFragment);
        if (nextFragment != null) {
            final FragmentTransaction ft = fm.beginTransaction();
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.replace(R.id.fragment_container, nextFragment).commit();
        } else {
            final SharedPreferences.Editor editor =
                    PreferenceManager.getDefaultSharedPreferences(this).edit();
            editor.putBoolean(APP_PROVISIONED, true).apply();
            finish();
        }
    }
}
