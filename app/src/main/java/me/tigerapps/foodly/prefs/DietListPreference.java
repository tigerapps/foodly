package me.tigerapps.foodly.prefs;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

import me.tigerapps.foodly.data.Diet;

/**
 * ListPreference that is automatically filled with the list of configurations.
 */

public class DietListPreference extends ListPreference {
    public DietListPreference(final Context context, final AttributeSet attrs,
                              final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        final Diet[] diets = Diet.values();
        final CharSequence[] entries = new CharSequence[diets.length];
        for (int i = 0; i < diets.length; ++i)
            entries[i] = context.getResources().getString(diets[i].getLabelResId());
        setEntries(entries);
        final CharSequence[] values = new CharSequence[diets.length];
        for (int i = 0; i < diets.length; ++i)
            values[i] = diets[i].getName();
        setEntryValues(values);
    }

    public DietListPreference(final Context context, final AttributeSet attrs,
                              final int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DietListPreference(final Context context, final AttributeSet attrs) {
        this(context, attrs, android.R.attr.dialogPreferenceStyle);
    }

    public DietListPreference(final Context context) {
        this(context, null);
    }
}
