package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.PendingAdapter;
import com.example.omnia.taskrabit.Models.LoginResponses.DataUser;
import com.example.omnia.taskrabit.Models.LogoutResponses.LogoutResponse;
import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.Models.PendingResponses.PendingResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Profile extends AppCompatActivity {
    DataUser data;
LinearLayout curr,neww,finish;
    private UserService userService;
    String d;

TextView Username,rate,workOrders,Logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Init();

        getInfo();
        setData();

        curr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Profile.this,CurrentOrders.class);
                intent.putExtra("token",data.getToken());
                startActivity(intent);

            }
        });

        neww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(Profile.this,NewOrders.class);
                intent.putExtra("token",data.getToken());
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Profile.this,"hiii", Toast.LENGTH_SHORT).show();
                sendRequest();
            }
        });

    }

    public void sendRequest()
    {
        Call<LogoutResponse> call=userService.Logouts("Bearer "+data.getToken());
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {

                        Toast.makeText(Profile.this,"hii", Toast.LENGTH_SHORT).show();

                    }
                    else {
                        Toast.makeText(Profile.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(Profile.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(Profile.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setData() {

        Username.setText(data.getName());
        workOrders.setText(data.getInfo());
    }

    private void getInfo() {
        Bundle bundle=getIntent().getExtras();
        if(!bundle.isEmpty())
        {
            data = (DataUser) bundle.get("Response");

        }

    }


    private void Init() {
        userService= ApiUtlis.getUserService();

        curr=(LinearLayout) findViewById(R.id.curr);
        neww=(LinearLayout) findViewById(R.id.neww);
        Username=(TextView) findViewById(R.id.uuser);
        finish=(LinearLayout) findViewById(R.id.finish);
        rate=(TextView) findViewById(R.id.rate);
        workOrders=(TextView) findViewById(R.id.workOrders);
        Logout=(TextView) findViewById(R.id.logout);

    }
}
