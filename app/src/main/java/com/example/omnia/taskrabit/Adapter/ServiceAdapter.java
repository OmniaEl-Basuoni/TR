package com.example.omnia.taskrabit.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.omnia.taskrabit.Classes.DataServices;
import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.R;

import java.util.List;

public class ServiceAdapter  extends RecyclerView.Adapter<ServiceAdapter.viewHolder> {

    List<DataServices> data;
    Context context;

    public ServiceAdapter(List<DataServices> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.service_raw, parent, false);
        return new ServiceAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(ServiceAdapter.viewHolder holder, int position) {
holder.service.setText(data.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class viewHolder extends RecyclerView.ViewHolder{

        public TextView service,minus;


        public viewHolder(View itemView) {
            super(itemView);
            service=(TextView) itemView.findViewById(R.id.serv);

        }
    }
}
