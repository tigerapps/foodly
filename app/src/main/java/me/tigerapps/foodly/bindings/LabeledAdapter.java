package me.tigerapps.foodly.bindings;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;

import me.tigerapps.foodly.data.Labeled;
import me.tigerapps.foodly.databinding.LabeledItemBinding;

class LabeledAdapter<T extends Labeled> extends BaseAdapter implements SpinnerAdapter {
    private final Context context;
    private final T[] entries;

    public LabeledAdapter(final Context context, final T[] entries) {
        this.context = context;
        this.entries = entries;
    }

    @Override
    public int getCount() {
        return entries.length;
    }

    @Override
    public T getItem(final int position) {
        return entries[position];
    }

    @Override
    public long getItemId(final int position) {
        return entries[position].hashCode();
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(final int position, final View convertView, final ViewGroup parent) {
        LabeledItemBinding binding = DataBindingUtil.getBinding(convertView);
        if (binding == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(context);
            binding = LabeledItemBinding.inflate(layoutInflater, parent, false);
        }
        binding.setItem(getItem(position));
        binding.executePendingBindings();
        return binding.getRoot();
    }
}
