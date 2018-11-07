package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
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
    int subID;
    private UserService userService;
    Button next;
    EditText hint , phone;
    Spinner country,city;
    CountryAdapter countryAdapter;
    CityAdapter cityAdapter;
    EditText Username,Email,Password,Repassword;


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

            isValid();
            }
        });
    }


    public void isValid()
    {
        String email=Email.getText().toString().trim();
        String user=Username.getText().toString().trim();
        String pass=Password.getText().toString().trim();
        String repass=Repassword.getText().toString().trim();

        if (TextUtils.isEmpty(user)){
            Username.setError("Enter your Username");
            Username.requestFocus();
            return;
        }
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Email.setError(getResources().getString(R.string.PleaseEnterYourEmail));
            Email.requestFocus();
            return;
        }




        if (TextUtils.isEmpty(pass)){
            Password.setError("Enter your Password");
            Password.requestFocus();
            return;
        }



        if (!(pass.equals(repass))){
            Repassword.setError("غير متطابقان");
            Repassword.requestFocus();
            return;
        }



        goNext();

    }

    private void goNext() {
        Intent intent=new Intent(this,Information.class);
        intent.putExtra("username",Username.getText().toString().trim());
        intent.putExtra("email",Email.getText().toString().trim());
        intent.putExtra("pass",Password.getText().toString().trim());
        intent.putExtra("city",subID);
        startActivity(intent);
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

        city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                LocationData data=(LocationData) parent.getItemAtPosition(position);
                subID=data.getId();
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
        Username=(EditText) findViewById(R.id.user);
        Email=(EditText) findViewById(R.id.email);
        Password=(EditText) findViewById(R.id.pass);
        Repassword=(EditText) findViewById(R.id.repass);


    }


}
