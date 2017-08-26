package com.example.android.miwok;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Bhavya Arora on 8/2/2017.
 */
////////So Sorry It's CustomAdapter///////////////////////////////////////////////////////////////

public class customerAdapter extends ArrayAdapter<info> {
    private int colorValue;
    LinearLayout textArea;

    public customerAdapter(@NonNull Context context, @NonNull List<info> objects, int color) {
        super(context, R.layout.list_item, objects);
        ///////Because we are getting color info as well///////////////
        colorValue = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        info currentInfo = getItem(position);
        TextView mName = (TextView) listItemView.findViewById(R.id.name);
        TextView mBranch = (TextView) listItemView.findViewById(R.id.branch);
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        mName.setText(currentInfo.getName());
        mBranch.setText(currentInfo.getBranch());
        textArea = (LinearLayout) listItemView.findViewById(R.id.textArea);
        int color = ContextCompat.getColor(getContext(), colorValue);
        textArea.setBackgroundColor(color);
        if (currentInfo.hasImage()) {
            imageView.setImageResource(currentInfo.getImageResourceid());
        } else {
            imageView.setVisibility(View.GONE);
        }
        return listItemView;
    }
}
