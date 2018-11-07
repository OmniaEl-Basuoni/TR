package com.example.omnia.taskrabit.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Classes.DataServices;
import com.example.omnia.taskrabit.Models.AcceptOrderResponses.Data;
import com.example.omnia.taskrabit.R;

import javax.net.ssl.SSLEngineResult;

public class ServicesActivtity extends AppCompatActivity {

    Button next;
    TextView plus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);

        Init();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),TransportWay.class));
            }
        });

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(ServicesActivtity.this,AddServiceActivity.class);
                startActivityForResult(intent,100);

            }
        });

    }

    private void Init() {
        next=(Button) findViewById(R.id.next);
        plus=(TextView) findViewById(R.id.plus);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) {
            if(resultCode == Activity.RESULT_OK){
                String ser= data.getStringExtra("ser");
                String pr= data.getStringExtra("pr");
                String to= data.getStringExtra("to");

                if (!ser.equals("")&&!pr.equals("")&&!to.equals(""))
                {
                    DataServices dataServices=new DataServices();
                    dataServices.setSubCategoryId(ser);
                    dataServices.setPrice(Integer.parseInt(pr));
                    dataServices.setTools(to);
                }

                ShowData();
            }

        }

    }

    private void ShowData() {




    }
}
