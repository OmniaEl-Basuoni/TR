package com.example.omnia.taskrabit.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.PendingAdapter;
import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.Models.PendingResponses.PendingResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FinishedOrders extends AppCompatActivity {

    PendingAdapter pendingAdapter;
    RecyclerView finishedOrders;
    private UserService userService;

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finished_orders);

        Init();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        finishedOrders.setLayoutManager(mLayoutManager);

        getInfo();
        startResponse(1);
    }
    private void getInfo() {
        Bundle bundle=getIntent().getExtras();
        if(!bundle.isEmpty())
        {
            data = (String) bundle.get("token");

        }
    }
    private void startResponse(int id) {
        Call<PendingResponse> call=userService.Finished("Bearer "+data,id);
        call.enqueue(new Callback<PendingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<PendingResponse> call, Response<PendingResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        List<Order> data = response.body().getData().getOrders();
                        Toast.makeText(FinishedOrders.this, ""+data.size(), Toast.LENGTH_SHORT).show();
                        pendingAdapter=new PendingAdapter(data,FinishedOrders.this);
                        finishedOrders.setAdapter(pendingAdapter);

                    }
                    else {
                        Toast.makeText(FinishedOrders.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(FinishedOrders.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<PendingResponse> call, Throwable t) {
                Toast.makeText(FinishedOrders.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void Init() {
        userService= ApiUtlis.getUserService();

        finishedOrders=(RecyclerView) findViewById(R.id.finishedOrders);
    }





}
