package com.example.omnia.taskrabit.Activity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Models.LoginResponses.DataUser;
import com.example.omnia.taskrabit.Models.LoginResponses.LoginResponse;
import com.example.omnia.taskrabit.Models.TaskerInfoResponses.TaskerInfoResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    private DataUser dataUser;
    private Dialog progressDialog;
    private UserService userService;
    EditText edtUsername,edtPassword;
  Button enter ;
  TextView register ,reset;
  DataUser data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        Init();
       onClick();


    }

    private void onClick() {
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validData();

            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),SignUp.class));

            }
        });
    }

    private void validData() {


        String Email=edtUsername.getText().toString().trim();
        String Password=edtPassword.getText().toString().trim();

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(Email).matches()){
            edtUsername.setError(getResources().getString(R.string.PleaseEnterYourEmail));
            edtUsername.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Password)){
            edtPassword.setError(getResources().getString(R.string.PleaseEnterYourName));
            edtPassword.requestFocus();
            return;
        }


        callLogin(Email,Password);
    }

    private void callLogin(String email,String pass) {
        ShowWaiting();
       Call<LoginResponse>call=userService.Login("en",email,pass);
       call.enqueue(new Callback<LoginResponse>() {
           @Override
           public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
               if (response.isSuccessful()) {
                   if (response.body().getValue())
                   {
                       dataUser=response.body().getData();
                       callTaskerInfo();
                   }
                   else {
                       Toast.makeText(LoginActivity.this, response.body().getMsg(), Toast.LENGTH_SHORT).show();
                       progressDialog.dismiss();
                   }
               }
               else
               {
                   progressDialog.dismiss();
                   Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();
               }
           }

           @Override
           public void onFailure(Call<LoginResponse> call, Throwable t) {
               progressDialog.dismiss();
               Toast.makeText(LoginActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
           }
       });
    }

    private void callTaskerInfo() {


        Call<TaskerInfoResponse> call=userService.TaskerInfo("Bearer "+dataUser.getToken());
        call.enqueue(new Callback<TaskerInfoResponse>() {
            @Override
            public void onResponse(Call<TaskerInfoResponse> call, Response<TaskerInfoResponse> response) {
                if (response.isSuccessful())
                {
                    if (response.body().getValue())
                    {
                        Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
                        intent.putExtra("Response",dataUser);
                        intent.putExtra("Pending",response.body().getData().getPendingOrders());
                        intent.putExtra("Accepted",response.body().getData().getAcceptedOrders());
                        intent.putExtra("Finished",response.body().getData().getFinishedOrders());
                        startActivity(intent);
                        finish();
                        progressDialog.dismiss();
                    }
                }
            }

            @Override
            public void onFailure(Call<TaskerInfoResponse> call, Throwable t) {

            }
        });

    }

    private void Init() {
        userService= ApiUtlis.getUserService();


        enter=(Button) findViewById(R.id.btnEnter2);
        reset=(TextView)findViewById(R.id.reset);
        register=(TextView) findViewById(R.id.reg);
        edtUsername=(EditText) findViewById(R.id.edtUsername);
        edtPassword=(EditText) findViewById(R.id.edtPassword);
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
