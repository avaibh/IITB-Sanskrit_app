package com.SansTranslate.android.sanskrit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by vaibhavagrawal on 05/07/17.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context context) {
        mContext = context;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.temple_intro,
            R.drawable.school_intro,
            R.drawable.number_intro,
            R.drawable.color_intro,
            R.drawable.family_intro,
            R.drawable.phrases_intro1,
            R.drawable.sports_intro,
            R.drawable.time_intro,
            R.drawable.sky_intro,
            R.drawable.water_intro,
            R.drawable.tree_intro,
            R.drawable.flower_intro
    };

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            gridView = new View(mContext);

            // get layout from mobile.xml
            gridView = inflater.inflate(R.layout.custom_grid, null);

            ImageView imageView = (ImageView) gridView.findViewById(R.id.grid_image_view);
            imageView.setImageResource(mThumbIds[position]);

        } else {
            gridView = (View) convertView;
        }
        return gridView;
    }

}
