package com.example.omnia.taskrabit.Activity;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.SubCategoryAdapter;
import com.example.omnia.taskrabit.Classes.DataServices;
import com.example.omnia.taskrabit.Models.SubCategoryResponses.Datum;
import com.example.omnia.taskrabit.Models.SubCategoryResponses.SubCategoryResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddServiceActivity extends AppCompatActivity {

    private TextView price,tools;
    private int service_ID;
    private String service_Name;
    private Button buttonAdd;
    Spinner service,workDays,workHours;
    private UserService userService;
    SubCategoryAdapter subCategoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        Init();
        sendRequest();


        onClick();

        onChange();

    }

    private void onChange() {
        service.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Datum datum=(Datum) adapterView.getItemAtPosition(i);
                service_ID=datum.getId();
                service_Name=datum.getName();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void onClick() {



       buttonAdd.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent returnIntent = new Intent();
               returnIntent.putExtra("ser",service_ID+"");
               returnIntent.putExtra("pr",price.getText().toString().trim());
               returnIntent.putExtra("to",tools.getText().toString().trim());
               returnIntent.putExtra("name",service_Name);
               setResult(Activity.RESULT_OK,returnIntent);
               finish();
           }
       });


    }

    private void Init() {
        service=(Spinner) findViewById(R.id.service);
        userService= ApiUtlis.getUserService();


        price=findViewById(R.id.price);
        tools=findViewById(R.id.tools);

        buttonAdd=findViewById(R.id.next);

    }





    private void sendRequest() {
        Call<SubCategoryResponse> call=userService.SubCategory();
        call.enqueue(new Callback<SubCategoryResponse>() {

            @Override
            public void onResponse(Call<SubCategoryResponse> call, Response<SubCategoryResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        subCategoryAdapter=new SubCategoryAdapter(AddServiceActivity.this,response.body().getData());
                        service.setAdapter(subCategoryAdapter);
                    }
                    else {
                        Toast.makeText(AddServiceActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(AddServiceActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<SubCategoryResponse> call, Throwable t) {

                Toast.makeText(AddServiceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }



}
