
package com.example.omnia.taskrabit.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.CurrentAdapter;
import com.example.omnia.taskrabit.Adapter.ServiceAdapter;
import com.example.omnia.taskrabit.Classes.DataServices;
import com.example.omnia.taskrabit.Classes.SharedParameter;
import com.example.omnia.taskrabit.Models.AcceptOrderResponses.Data;
import com.example.omnia.taskrabit.R;

import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.SSLEngineResult;

public class ServicesActivtity extends AppCompatActivity {

    private String hint,phone,user,email,password;
    private int cityID;
    Button next;
    TextView plus;
List<DataServices> dataList=new ArrayList<DataServices>();
RecyclerView services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Init();

        getData();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
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

    private void getData() {
        Bundle bundle=getIntent().getExtras();
        if (!bundle.isEmpty())
        {
            hint=bundle.getString("Hint");
            phone=bundle.getString("Phone");
            user=bundle.getString("username");
            email=bundle.getString("email");
            password=bundle.getString("pass");
            cityID=(int)bundle.get("city");
        }
    }

    private void goNext() {


        SharedParameter.dataServices=dataList;
        Intent intent=new Intent(this,TransportWay.class);
        intent.putExtra("Hint",hint);
        intent.putExtra("Phone",phone);
        intent.putExtra("username",user);
        intent.putExtra("email",email);
        intent.putExtra("pass",password);
        intent.putExtra("city",cityID);
        startActivity(intent);

    }

    private void Init() {
        next=(Button) findViewById(R.id.next);
        plus=(TextView) findViewById(R.id.plus);
        services=(RecyclerView) findViewById(R.id.services);
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        services.setLayoutManager(mLayoutManager);

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 100) {

            if(resultCode == Activity.RESULT_OK){
                DataServices dataServices=new DataServices();

                String ser= data.getStringExtra("ser");
                String pr= data.getStringExtra("pr");
                String to= data.getStringExtra("to");
                String name=data.getStringExtra("name");


                if (!ser.equals("")&&!pr.equals("")&&!to.equals(""))
                {
                    dataServices.setSubCategoryId(ser);
                    dataServices.setPrice(Integer.parseInt(pr));
                    dataServices.setName(name);
                    dataServices.setTools(to);
                }
                dataList.add(dataServices);
                ShowData();
            }

        }

    }

    private void ShowData() {

        ServiceAdapter ServiceAdapter=new ServiceAdapter(dataList,ServicesActivtity.this);
        services.setAdapter(ServiceAdapter);



    }
}
