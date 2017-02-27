package com.example.glego.resistorsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

/**
 * Created by HOME-I on 19/02/2017.
 */

public class MyAdapter extends ArrayAdapter<ResistorCode> {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mDataSource;

    public MyAdapter(Context context, ArrayList<ResistorCode> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        ResistorCode codes = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
           convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_bands, parent, false);
        }
        //mInflater.inflate(R.layout.list_item_bands, parent, false);
        // Lookup view for data population
        TextView tvColor = (TextView) convertView.findViewById(R.id.list_title);
        TextView tvBand = (TextView) convertView.findViewById(R.id.list_subtitle);
        ImageView ivIcon = (ImageView) convertView.findViewById(R.id.list_icon);
        // Populate the data into the template view using the data object
        tvColor.setText(codes.color);
        tvBand.setText(codes.band);
        ivIcon.setImageResource(codes.imageId);
        // Return the completed view to render on screen
        return convertView;
    }
    /*//1
    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_bands, parent, false);
        // Get title element
        TextView titleTextView = (TextView) rowView.findViewById(R.id.list_title);

        // Get subtitle element
        TextView subtitleTextView = (TextView) rowView.findViewById(R.id.list_subtitle);

        // Get detail element
        TextView detailTextView = (TextView) rowView.findViewById(R.id.list_detail);

        // Get thumbnail element
        ImageView iconImageView = (ImageView) rowView.findViewById(R.id.list_icon);
        return rowView;
    }*/
}