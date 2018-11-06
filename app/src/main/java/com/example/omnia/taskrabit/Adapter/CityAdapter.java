package com.example.omnia.taskrabit.Adapter;

/**
 * Created by Omnia on 11/5/2018.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.LocationsResponses.LocationData;
import com.example.omnia.taskrabit.R;

import java.util.List;

public class CityAdapter extends BaseAdapter {
    Context context;
    List<LocationData> RegionData;

    public CityAdapter(Context context, List<LocationData> regionData) {
        this.context = context;
        RegionData = regionData;
    }



    @Override
    public int getCount() {
        return RegionData.size();
    }

    @Override
    public Object getItem(int i) {
        return RegionData.get(i);
    }

    @Override
    public long getItemId(int i) {
        if (RegionData.size()==0)
            return 0;
        else
            return RegionData.indexOf(RegionData.get(i));
    }

    class ViewHolder
    {
        TextView city;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        CityAdapter.ViewHolder holder=null;

        LayoutInflater mIFlater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View row=mIFlater.inflate(R.layout.view_spinner,viewGroup,false);

        holder=new CityAdapter.ViewHolder();

        holder.city=row.findViewById(R.id.spinnerView);

        holder.city.setText(RegionData.get(i).getName());
        return row;

    }
}

