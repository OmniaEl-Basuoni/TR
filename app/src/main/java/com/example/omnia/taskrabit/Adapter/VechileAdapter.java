package com.example.omnia.taskrabit.Adapter;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.LocationsResponses.LocationData;
import com.example.omnia.taskrabit.Models.VechileResponses.Datum;
import com.example.omnia.taskrabit.R;

import java.util.List;

/**
 * Created by Omnia on 11/7/2018.
 */

public class VechileAdapter extends BaseAdapter{

    Context context;
    List<Datum> rowItems;

    public VechileAdapter(Context context, List<Datum> rowItems) {
        this.context = context;
        this.rowItems = rowItems;
    }

    @Override
    public int getCount() {
        return rowItems.size();
    }

    @Override
    public Object getItem(int i) {
        return rowItems.get(i);

    }

    @Override
    public long getItemId(int i) {
        return rowItems.indexOf(getItem(i));

    }

    private class ViewHolder {
        TextView txtTitle;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        VechileAdapter.ViewHolder holder = null;

        LayoutInflater mInflater = (LayoutInflater)
                context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        view = mInflater.inflate(R.layout.view_spinner, null);
        holder = new ViewHolder();
        holder.txtTitle =  view.findViewById(R.id.spinnerView);

        Datum rowItem = (Datum) getItem(i);


        holder.txtTitle.setText(rowItem.getName()+"");

        return view;
    }


}
