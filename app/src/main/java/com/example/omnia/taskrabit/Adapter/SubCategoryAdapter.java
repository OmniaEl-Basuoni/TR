package com.example.omnia.taskrabit.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.LocationsResponses.LocationData;
import com.example.omnia.taskrabit.Models.SubCategoryResponses.Datum;
import com.example.omnia.taskrabit.R;


import java.util.List;

/**
 * Created by 3ZT on 10/23/2017.
 */

public class SubCategoryAdapter extends BaseAdapter {
    Context context;
    List<Datum> RegionData;

    public SubCategoryAdapter(Context context, List<Datum> regionData) {
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

        ViewHolder holder=null;

        LayoutInflater mIFlater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        View row=mIFlater.inflate(R.layout.view_spinner,viewGroup,false);

        holder=new ViewHolder();

        holder.city=row.findViewById(R.id.spinnerView);

        holder.city.setText(RegionData.get(i).getName());
        return row;

    }
}

