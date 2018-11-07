package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.omnia.taskrabit.R;

public class PaymentInfo extends AppCompatActivity {

    Button record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

        Init();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String cardNumber = bundle.getString("cardNumber");
            String ownerName = bundle.getString("ownerName");
            String cvv = bundle.getString("cvv");
        }
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),ProfileActivity.class));

            }
        });


    }

    private void Init() {
        record=(Button) findViewById(R.id.record);
    }
}
