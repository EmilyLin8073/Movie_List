package com.example.project2;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

public class ImageAdapter extends BaseAdapter {
    private static final int PADDING = 8;
    private static final int WIDTH = 300;
    private static final int HEIGHT = 300;
    private Context mContext;
    private List<Integer> bigImageID;


    //ImageAdapter constructor
    public ImageAdapter(List<Integer> bigImageID){
        this.bigImageID = bigImageID;
    }

    //The methods inherited from abstract superclass BaseAdapter
    //Return the number of items in the Adapter
    @Override
    public int getCount() {
        return bigImageID.size();
    }

    //Return the data item at position
    @Override
    public Object getItem(int position) {
        return bigImageID.get(position);
    }

    @Override
    public long getItemId(int position) {
        return bigImageID.get(position);
    }

    // Return an ImageView for each item referenced by the Adapter
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = (ImageView)convertView;

        //If convertView's not recycled, initialize some attributes
        if(imageView == null){
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new RelativeLayout.LayoutParams(WIDTH, HEIGHT));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        }

        imageView.setImageResource(bigImageID.get(position));
        return imageView;
    }
}
