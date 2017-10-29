package me.tigerapps.foodly.prefs;

import android.content.Context;
import android.preference.ListPreference;
import android.util.AttributeSet;

import me.tigerapps.foodly.data.DietLabel;

/**
 * ListPreference that is automatically filled with the list of configurations.
 */

public class DietLabelListPreference extends ListPreference {
    public DietLabelListPreference(final Context context, final AttributeSet attrs,
                                   final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        final DietLabel[] dietLabels = DietLabel.values();
        final CharSequence[] entries = new CharSequence[dietLabels.length];
        for (int i = 0; i < dietLabels.length; ++i)
            entries[i] = context.getResources().getString(dietLabels[i].getLabelResId());
        setEntries(entries);
        final CharSequence[] values = new CharSequence[dietLabels.length];
        for (int i = 0; i < dietLabels.length; ++i)
            values[i] = dietLabels[i].name();
        setEntryValues(values);
    }

    public DietLabelListPreference(final Context context, final AttributeSet attrs,
                                   final int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    public DietLabelListPreference(final Context context, final AttributeSet attrs) {
        this(context, attrs, android.R.attr.dialogPreferenceStyle);
    }

    public DietLabelListPreference(final Context context) {
        this(context, null);
    }
}
