package com.example.omnia.taskrabit.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.omnia.taskrabit.R;

public class Information extends AppCompatActivity {

    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        Init();

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(bundle != null){
            String hint = bundle.getString("hint");
            String phone = bundle.getString("phone");
        }

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(view.getContext(),Services.class));

            }
        });
    }

    private void Init() {
        next=(Button) findViewById(R.id.next);
    }
}
