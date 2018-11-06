package com.example.omnia.taskrabit.Adapter;

/**
 * Created by Omnia on 11/5/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.LocationsResponses.LocationData;
import com.example.omnia.taskrabit.R;

import java.util.List;
public class CountryAdapter extends BaseAdapter {
    Context context;
    List<LocationData> rowItems;

    public CountryAdapter(Context context, List<LocationData> items) {
        this.context = context;
        this.rowItems = items;
        Log.d("AQWE",items.get(0).getName());
    }

    /*private view holder class*/
    private class ViewHolder {
        TextView txtTitle;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = mInflater.inflate(R.layout.view_spinner, null);
            holder = new ViewHolder();
            holder.txtTitle =  convertView.findViewById(R.id.spinnerView);

        LocationData rowItem = (LocationData) getItem(position);


        holder.txtTitle.setText(rowItem.getId()+"");

        return convertView;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int position) {
        return rowItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return rowItems.indexOf(getItem(position));
    }
}