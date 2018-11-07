package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.omnia.taskrabit.R;

public class PaymentInfo extends AppCompatActivity {

    Button record;
    EditText cardNum,ownerName,cvv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_info);

        Init();
        goNext();

    /*    Intent intent = getIntent();
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
        }); */


    }



    private void Init() {
        cardNum=(EditText) findViewById(R.id.card);
        ownerName=(EditText) findViewById(R.id.owner);
        cvv=(EditText) findViewById(R.id.cvv);
        record=(Button) findViewById(R.id.record);
    }


    private void goNext() {
        Intent intent=new Intent(this,ProfileActivity.class);
        intent.putExtra("cardNumber",cardNum.getText().toString().trim());
        intent.putExtra("ownerName",ownerName.getText().toString().trim());
        intent.putExtra("cvv",cvv.getText().toString().trim());

        startActivity(intent);
    }
}



