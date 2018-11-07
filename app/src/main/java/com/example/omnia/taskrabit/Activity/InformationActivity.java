package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.omnia.taskrabit.R;

public class InformationActivity extends AppCompatActivity {
    private int cityID;
    private String user,email,password;
    private TextView txtHint,txtPhone;
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_information);

        Init();


        getData();


        onClick();
    }

    private void onClick() {

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isValidData();

            }
        });
    }

    private void isValidData() {

        String Hint=txtHint.getText().toString().trim();
        String Phone=txtPhone.getText().toString().trim();


        if (TextUtils.isEmpty(Hint)){
            txtHint.setError("هذا الحقل مطلوب ");
            txtHint.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(Phone)){
            txtPhone.setError("هذا الحقل مطلوب ");
            txtPhone.requestFocus();
            return;
        }


        goNext();
    }

    private void getData(){
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if(bundle != null){

            user=bundle.getString("username");
            email=bundle.getString("email");
            password=bundle.getString("password");
            cityID=(int)bundle.get("city");

        }
    }

    private void Init() {
        next=(Button) findViewById(R.id.next);
        txtHint=findViewById(R.id.hint);
        txtPhone=findViewById(R.id.phone);
    }

    private void goNext(){
        Intent intent=new Intent(this,ServicesActivtity.class);
        intent.putExtra("Hint",txtHint.getText().toString().trim());
        intent.putExtra("Phone",txtPhone.getText().toString().trim());
        intent.putExtra("username",user);
        intent.putExtra("email",email);
        intent.putExtra("pass",password);
        intent.putExtra("city",cityID);
        startActivity(intent);
    }
}
