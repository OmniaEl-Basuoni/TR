package com.example.omnia.taskrabit.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.omnia.taskrabit.Activity.CurrentOrderActivity;
import com.example.omnia.taskrabit.Activity.NewOrdersActivity;
import com.example.omnia.taskrabit.Models.AcceptOrderResponses.AcceptOrderResponse;
import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Omnia on 11/5/2018.
 */

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.viewHolder> {
    private UserService userService;
    List<Order> data;
    Context context;

    public CurrentAdapter(List<Order> data, Context context) {
        this.data = data;
        this.context =  context;
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.current_raw, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(CurrentAdapter.viewHolder holder, final int position) {

        holder.user.setText(data.get(position).getName());
        holder.salary.setText(data.get(position).getPrice());
        holder.date.setText(data.get(position).getDate());
        holder.details.setText(data.get(position).getDescription());


    }


    @Override
    public int getItemCount() {
        return data.size();
    }
    class viewHolder extends RecyclerView.ViewHolder{

        public TextView user,salary,details,date;


        public viewHolder(View itemView) {
            super(itemView);
            user=(TextView) itemView.findViewById(R.id.User);
            salary=(TextView) itemView.findViewById(R.id.salary);
            details=(TextView) itemView.findViewById(R.id.detail);
            date=(TextView) itemView.findViewById(R.id.date);
        }
    }


    }
