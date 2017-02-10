package com.skybox.isasetiawan.emochi;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by isasetiawan on 26/01/2017.
 */
class GridMenuAdapter extends BaseAdapter {

    private Context context;
    private Integer[] data;
    String name;

    GridMenuAdapter(Context context, Integer[] data) {
        this.context = context;
        this.data = data;
    }

    public GridMenuAdapter(Context context, Integer[] data, String name) {
        this.context = context;
        this.data = data;
        this.name = name;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        TextView textView;
        if (view == null) {
            imageView = new ImageView(context);
            textView = new TextView(context);

            imageView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            imageView.setAdjustViewBounds(true);
            imageView.setPadding(0,0,0,0);
        } else
            imageView = (ImageView) view;
        imageView.setImageResource(data[i]);

        return imageView;
    }
}
