package com.example.omnia.taskrabit.Activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.R;
import com.squareup.picasso.Picasso;


public class OrderFinishedDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView serviceName,serviceDate,name,txtPay,txtMoney;

    private LinearLayout Accept,Mange,Comment,Complete;
    private TextView txtTile,txtPrice;
    private Order order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.order_details);


        initComponents();
        
        getIntentData();

        setData();
    }

    private void setData() {
        txtPrice.setText(order.getPrice()+" ريال ");
        serviceName.setText(order.getDescription());
        serviceDate.setText(order.getDate());
        name.setText( " انجز "+order.getName()+" طلبك ");
        Picasso.with(this).load(order.getImage()).into(imageView);

        txtPay.setEnabled(false);

        txtMoney.setVisibility(View.VISIBLE);
        txtMoney.setText(" تم دفع مبلغ "+order.getPrice());
    }

    private void initComponents() {


        imageView=findViewById(R.id.photo);
        name=findViewById(R.id.name);
        txtPrice=findViewById(R.id.txtPrice);

        Accept=findViewById(R.id.Accept);
        Mange=findViewById(R.id.Mange);
        Comment=findViewById(R.id.Comment);
        Complete=findViewById(R.id.Complete);

        serviceDate=findViewById(R.id.serviceDate);
        serviceName=findViewById(R.id.serviceName);

        txtPay=findViewById(R.id.txtPay);
        txtMoney=findViewById(R.id.txtMoney);
    }

    private void getIntentData() {
        Bundle bundle=getIntent().getExtras();
        if (!bundle.isEmpty())
        {
            order=(Order) bundle.get("order");
        }
    }

}
