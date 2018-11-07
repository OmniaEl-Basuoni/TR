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
    EditText  cardNum,ownerName,cvv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_way);

        Init();
      ;


    }

    private void Init() {

        next=(Button) findViewById(R.id.next);
        cardNum=(EditText) findViewById(R.id.card);
        ownerName=(EditText) findViewById(R.id.owner);
        cvv=(EditText) findViewById(R.id.cvv);

    }
}
