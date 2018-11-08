package com.example.omnia.taskrabit.Activity;
import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.CurrentAdapter;
import com.example.omnia.taskrabit.Adapter.FinishingAdapter;
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

    private TextView txtTile;

    private Dialog progressDialog;
    private ImageView imageBack;

    FinishingAdapter pendingAdapter;
    RecyclerView finishedOrders;
    private UserService userService;

    String data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_finished_orders);

        Init();
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        finishedOrders.setLayoutManager(mLayoutManager);

        getInfo();
        startResponse(1);

        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void getInfo() {
        Bundle bundle=getIntent().getExtras();
        if(!bundle.isEmpty())
        {
            data = (String) bundle.get("token");

        }
    }
    private void startResponse(int id) {
        ShowWaiting();
        Call<PendingResponse> call=userService.Finished("Bearer "+data,id);
        call.enqueue(new Callback<PendingResponse>() {
            @Override
            public void onResponse(retrofit2.Call<PendingResponse> call, Response<PendingResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        if (response.body().getData().getOrders().size()==0)
                        {
                            txtTile.setVisibility(View.VISIBLE);
                        }
                        List<Order> data2 = response.body().getData().getOrders();
                        pendingAdapter=new FinishingAdapter(data2,FinishedOrders.this,data);
                        finishedOrders.setAdapter(pendingAdapter);
                        progressDialog.dismiss();
                    }
                    else {
                        Toast.makeText(FinishedOrders.this, response.message(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
                else
                {
                    Toast.makeText(FinishedOrders.this, response.message(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<PendingResponse> call, Throwable t) {
                Toast.makeText(FinishedOrders.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void Init() {
        userService= ApiUtlis.getUserService();

        txtTile=findViewById(R.id.order);
        finishedOrders=(RecyclerView) findViewById(R.id.finishedOrders);
        imageBack=findViewById(R.id.back);
    }


    private void ShowWaiting() {
        progressDialog = new Dialog(this);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.wait_dialog);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setCancelable(true);

        progressDialog.show();
    }



}
