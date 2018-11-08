package com.example.omnia.taskrabit.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Models.LoginResponses.DataUser;
import com.example.omnia.taskrabit.Models.LogoutResponses.LogoutResponse;
import com.example.omnia.taskrabit.Models.TaskerInfoResponses.TaskerInfoResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfileActivity extends AppCompatActivity {
    private Dialog progressDialog;
    private int pending=0,Accepted=0,Finished=0;
    private DataUser data;
    private LinearLayout curr,neww,finish;
    private UserService userService;
    private String d;
    private TextView txtPending,txtAccepted,txtFinished;
    private TextView Username,rate,workOrders,Logout;
    private CircleImageView profileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_profile);

        Init();

        getInfo();
        setData();

        onClick();

    }

    private void onClick() {
        curr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,CurrentOrderActivity.class);
                intent.putExtra("token",data.getToken());
               // intent.putExtra("image",data.getImage());
                startActivity(intent);

            }
        });

        neww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ProfileActivity.this,NewOrdersActivity.class);
                intent.putExtra("token",data.getToken());
                startActivity(intent);
            }
        });

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProfileActivity.this,FinishedOrders.class);
                intent.putExtra("token",data.getToken());
                startActivity(intent);
            }
        });

        Logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallLogout();
            }
        });
    }

    public void CallLogout() {
        ShowWaiting();
        Call<LogoutResponse> call=userService.Logouts("Bearer "+data.getToken());
        call.enqueue(new Callback<LogoutResponse>() {
            @Override
            public void onResponse(Call<LogoutResponse> call, Response<LogoutResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        Intent intent=new Intent(ProfileActivity.this,LoginActivity.class);
                        ActivityCompat.finishAffinity(ProfileActivity.this);
                        startActivity(intent);
                        progressDialog.dismiss();
                    }
                    else {
                        Toast.makeText(ProfileActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                        progressDialog.dismiss();
                    }
                }
                else
                {
                    Toast.makeText(ProfileActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    progressDialog.dismiss();
                }
            }

            @Override
            public void onFailure(retrofit2.Call<LogoutResponse> call, Throwable t) {
                Toast.makeText(ProfileActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void setData() {

        Username.setText(data.getName());
        workOrders.setText(data.getInfo());


         Picasso.with(this).load(data.getImage()).into(profileImage);


        txtAccepted.setText(Accepted+"");
        txtFinished.setText(Finished+"");
        txtPending.setText(pending+"");
    }

    private void getInfo() {
        Bundle bundle=getIntent().getExtras();
        if(!bundle.isEmpty())
        {
            data = (DataUser) bundle.get("Response");
            pending=(int)bundle.get("Pending");
            Accepted=(int)bundle.get("Accepted");
            Finished=(int)bundle.get("Finished");
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

        txtPending=findViewById(R.id.txtPending);
        txtFinished=findViewById(R.id.txtFinished);
        txtAccepted=findViewById(R.id.txtAccepted);
        profileImage=(CircleImageView)findViewById(R.id.profile_image);
    }

    private void ShowWaiting() {
        progressDialog = new Dialog(this);
        progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        progressDialog.setContentView(R.layout.wait_dialog);
        progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        progressDialog.setCancelable(true);

        progressDialog.show();
    }

    private void callTaskerInfo() {


        Call<TaskerInfoResponse> call=userService.TaskerInfo("Bearer "+data.getToken());
        call.enqueue(new Callback<TaskerInfoResponse>() {
            @Override
            public void onResponse(Call<TaskerInfoResponse> call, Response<TaskerInfoResponse> response) {
                if (response.isSuccessful())
                {
                    if (response.body().getValue())
                    {
                        txtAccepted.setText(response.body().getData().getAcceptedOrders());
                        txtFinished.setText(response.body().getData().getFinishedOrders());
                        txtPending.setText(response.body().getData().getPendingOrders());
                    }
                }
            }

            @Override
            public void onFailure(Call<TaskerInfoResponse> call, Throwable t) {

            }
        });

    }


}

