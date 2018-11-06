package com.example.omnia.taskrabit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.CurrentResponses.Data;
import com.example.omnia.taskrabit.R;

import java.util.List;

/**
 * Created by Omnia on 11/5/2018.
 */

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.viewHolder> {
    List<Data> data;
    Context context;

    public CurrentAdapter(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.current_raw, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurrentAdapter.viewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{

        public TextView user,salary,details,date;
        public ImageView image;


        public viewHolder(View itemView) {
            super(itemView);
        }
    }


    }
