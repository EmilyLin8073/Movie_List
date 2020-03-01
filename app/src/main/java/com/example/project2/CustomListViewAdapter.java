package com.example.project2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<DataItem> {

    Context context;

    public CustomListViewAdapter(Context context, int resourceID, List<DataItem> items){
        super(context, resourceID, items);
        this.context = context;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView txtTitle;
        TextView txtYear;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        ViewHolder holder = null;
        DataItem dataItem = getItem(position);

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if(convertView == null){
            convertView = layoutInflater.inflate(R.layout.list_item, null);
            holder = new ViewHolder();
            holder.txtTitle = (TextView)convertView.findViewById(R.id.title);
            holder.txtYear = (TextView)convertView.findViewById(R.id.year);
            holder.imageView = (ImageView)convertView.findViewById(R.id.icon);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }

        // if convertView's not recycled, initialize some attributes
        if (holder.imageView == null) {
            holder.imageView = new ImageView(context);
            holder.imageView.setScaleType(ImageView.ScaleType.CENTER);
        }

        holder.txtTitle.setText((dataItem.getTitles()));
        holder.txtYear.setText(dataItem.getYears());
        holder.imageView.setImageResource(dataItem.getImageID());

        return convertView;
    }
}
