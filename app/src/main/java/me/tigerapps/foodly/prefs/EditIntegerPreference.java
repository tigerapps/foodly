package me.tigerapps.foodly.prefs;

import android.content.Context;
import android.preference.EditTextPreference;
import android.util.AttributeSet;

public class EditIntegerPreference extends EditTextPreference {
    public EditIntegerPreference(final Context context, final AttributeSet attrs,
                                 final int defStyleAttr, final int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public EditIntegerPreference(final Context context, final AttributeSet attrs,
                                 final int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EditIntegerPreference(final Context context, final AttributeSet attrs) {
        super(context, attrs);
    }

    public EditIntegerPreference(final Context context) {
        super(context);
    }

    @Override
    protected String getPersistedString(final String defaultReturnValue) {
        return String.valueOf(getPersistedInt(0));
    }

    @Override
    protected boolean persistString(final String value) {
        return persistInt(Integer.valueOf(value));
    }
}
