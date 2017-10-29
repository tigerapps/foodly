package me.tigerapps.foodly.prefs;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

import me.tigerapps.foodly.data.Sex;

/**
 * ListPreference that is automatically filled with the list of configurations.
 */

public class SexListPreference extends ListPreference {
    public SexListPreference(final Context context, final AttributeSet attrs,
                             final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        final Sex[] sexes = Sex.values();
        final CharSequence[] entries = new CharSequence[sexes.length];
        for (int i = 0; i < sexes.length; ++i)
            entries[i] = context.getResources().getString(sexes[i].getLabelResId());
        setEntries(entries);
        setEntryValues(entries);
    }

    public SexListPreference(final Context context, final AttributeSet attrs,
                             final int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public SexListPreference(final Context context, final AttributeSet attrs) {
        this(context, attrs, android.R.attr.dialogPreferenceStyle);
    }

    public SexListPreference(final Context context) {
        this(context, null);
    }
}
