package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.omnia.taskrabit.Adapter.CityAdapter;
import com.example.omnia.taskrabit.Adapter.CountryAdapter;
import com.example.omnia.taskrabit.Models.LocationsResponses.CitiesResponse;
import com.example.omnia.taskrabit.Models.LocationsResponses.LocationData;
import com.example.omnia.taskrabit.Models.LocationsResponses.LocationResponse;
import com.example.omnia.taskrabit.R;
import com.example.omnia.taskrabit.Remote.ApiUtlis;
import com.example.omnia.taskrabit.Remote.UserService;

import org.angmarch.views.NiceSpinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUp extends AppCompatActivity {
    private UserService userService;
    Button next;
    EditText hint , phone;
    Spinner country,city;
    CountryAdapter countryAdapter;
    CityAdapter cityAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Init();
        sendRequest();

        spinnerInfo();

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Information.class);
                intent.putExtra("hint", hint.getText()+"");
                intent.putExtra("phone", phone.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void spinnerInfo() {

        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LocationData data=(LocationData) parent.getItemAtPosition(position);
                sendCities(data.getId());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void sendCities(int id) {
        Call<CitiesResponse> call=userService.Cities("en",id);
        call.enqueue(new Callback<CitiesResponse>() {

            @Override
            public void onResponse(Call<CitiesResponse> call, Response<CitiesResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        cityAdapter=new CityAdapter(SignUp.this,response.body().getData());
                        city.setAdapter(cityAdapter);
                    }
                    else {
                        Toast.makeText(SignUp.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignUp.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CitiesResponse> call, Throwable t) {

                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void sendRequest() {
        Call<LocationResponse> call=userService.Locations("en");
        call.enqueue(new Callback<LocationResponse>() {

            @Override
            public void onResponse(Call<LocationResponse> call, Response<LocationResponse> response) {
                if (response.isSuccessful()) {
                    if (response.body().getValue())
                    {
                        countryAdapter=new CountryAdapter(SignUp.this,response.body().getData());
                        country.setAdapter(countryAdapter);
                    }
                    else {
                        Toast.makeText(SignUp.this, response.message(), Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    Toast.makeText(SignUp.this, response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LocationResponse> call, Throwable t) {

                Toast.makeText(SignUp.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void Init() {
        userService= ApiUtlis.getUserService();

        next=(Button) findViewById(R.id.next);
        hint=(EditText) findViewById(R.id.hint);
        phone=(EditText)findViewById(R.id.phone);
         country=(Spinner) findViewById(R.id.country);
         city=(Spinner) findViewById(R.id.city);


    }


}
