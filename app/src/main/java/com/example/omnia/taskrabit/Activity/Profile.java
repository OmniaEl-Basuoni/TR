package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.omnia.taskrabit.R;

public class Profile extends AppCompatActivity {
LinearLayout curr,neww;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Init();

        curr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),CurrentOrders.class));

            }
        });

        neww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),NewOrders.class));

            }
        });

    }

    private void Init() {
        curr=(LinearLayout) findViewById(R.id.curr);
        neww=(LinearLayout) findViewById(R.id.neww);
    }
}
