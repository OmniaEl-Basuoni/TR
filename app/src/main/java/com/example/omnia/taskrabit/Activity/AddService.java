package com.example.omnia.taskrabit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.omnia.taskrabit.R;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AddService extends AppCompatActivity {

    NiceSpinner service,workDays,workHours;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_service);
        Init();

    }

    private void Init() {
        service=(NiceSpinner) findViewById(R.id.service);
        workDays=(NiceSpinner) findViewById(R.id.workDays);
        workHours=(NiceSpinner) findViewById(R.id.workHours);
    }


}
