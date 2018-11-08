package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

public class PayInfoActivity extends AppCompatActivity {
    private UserService userService;
    private String hint,phone,user,email,password;
    private int cityID;
    Button record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

        Init();

        getData();

    }

    private void Init() {
        record=(Button) findViewById(R.id.record);
        userService=ApiUtlis.getUserService();
    }

    private void getData() {
    }

    private void onClick(){
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallRegister();
            }
        });
    }

    private void CallRegister() {

    }
}
