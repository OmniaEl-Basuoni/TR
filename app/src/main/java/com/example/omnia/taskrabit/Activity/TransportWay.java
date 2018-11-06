package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.omnia.taskrabit.R;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TransportWay extends AppCompatActivity {
Button next;
    NiceSpinner transportWay;
    EditText  cardNum,ownerName,cvv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_way);

        Init();
      ;

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(view.getContext(), PaymentInfo.class);
                intent.putExtra("cardNumber", cardNum.getText().toString());
                intent.putExtra("ownerName", ownerName.getText().toString());
                intent.putExtra("cvv", cvv.getText().toString());

                startActivity(intent);

            }
        });
    }

    private void Init() {

        next=(Button) findViewById(R.id.next);
        transportWay=(NiceSpinner) findViewById(R.id.transportWay);
        cardNum=(EditText) findViewById(R.id.card);
        ownerName=(EditText) findViewById(R.id.owner);
        cvv=(EditText) findViewById(R.id.cvv);

    }
}
