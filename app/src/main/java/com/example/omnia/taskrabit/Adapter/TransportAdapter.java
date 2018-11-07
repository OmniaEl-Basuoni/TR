package com.example.omnia.taskrabit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omnia.taskrabit.Classes.DataServices;
import com.example.omnia.taskrabit.Models.VechileResponses.Datum;
import com.example.omnia.taskrabit.R;

import java.util.List;

/**
 * Created by Omnia on 11/7/2018.
 */

public class TransportAdapter  extends RecyclerView.Adapter<TransportAdapter.viewHolder> {

    List<Datum> data;
    Context context;

    public TransportAdapter(List<Datum> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_raw, parent, false);
        return new TransportAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(TransportAdapter.viewHolder holder, int position) {
        holder.transport.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        public TextView transport;


        public viewHolder(View itemView) {
            super(itemView);
            transport=(TextView) itemView.findViewById(R.id.serv);

        }
    }
}

