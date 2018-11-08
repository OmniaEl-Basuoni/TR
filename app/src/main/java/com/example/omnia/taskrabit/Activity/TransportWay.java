package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.CountryAdapter;
import com.example.omnia.taskrabit.Adapter.VechileAdapter;
import com.example.omnia.taskrabit.Models.LocationsResponses.LocationResponse;
import com.example.omnia.taskrabit.Models.SubCategoryResponses.Datum;
import com.example.omnia.taskrabit.Models.VechileResponses.VechileResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TransportWay extends AppCompatActivity {
Button next;
    EditText  cardNum,ownerName,cvv;
    Spinner transportWay;
    RecyclerView recycletransportWay;
    private UserService userService;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transport_way);

        Init();
        sendRequest();
        TransportInfo();
        onChange();


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TransportWay.this,PayInfoActivity.class);
                startActivity(intent);

            }
        });
    }

    private void TransportInfo() {

    }


    private void onChange() {
        transportWay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }


    public  void sendRequest()
    {
        Call<VechileResponse> call=userService.Vechile();
        call.enqueue(new Callback<VechileResponse>() {

            @Override
            public void onResponse(Call<VechileResponse> call, Response<VechileResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        VechileAdapter v=new VechileAdapter(TransportWay.this,response.body().getData());
                        transportWay.setAdapter(v);
                    }
                    else {
                        Toast.makeText(TransportWay.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(TransportWay.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<VechileResponse> call, Throwable t) {

                Toast.makeText(TransportWay.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void Init() {
        userService= ApiUtlis.getUserService();

        next=(Button) findViewById(R.id.next);
        cardNum=(EditText) findViewById(R.id.card);
        ownerName=(EditText) findViewById(R.id.owner);
        cvv=(EditText) findViewById(R.id.cvv);
        transportWay=(Spinner) findViewById(R.id.transportWay);

        recycletransportWay=(RecyclerView) findViewById(R.id.transport);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 1);
        recycletransportWay.setLayoutManager(mLayoutManager);

    }
}
