package com.example.omnia.taskrabit.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.omnia.taskrabit.Models.PendingResponses.Order;
import com.example.omnia.taskrabit.R;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class OrderDetailsActivity extends AppCompatActivity {

    Order order;
    TextView Mtlob,Date,Price,date,Details;
    CircleImageView Image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Init();
        getInfo();
        setData();
    }

    private void Init() {
        Mtlob=(TextView)findViewById(R.id.mtlob);
        Date=(TextView) findViewById(R.id.date);
        Price=(TextView)findViewById(R.id.price);
        Details=(TextView) findViewById(R.id.details);
        date=(TextView) findViewById(R.id.Date);
        Image=(CircleImageView) findViewById(R.id.img);
    }

    private void getInfo() {
        Bundle bundle=getIntent().getExtras();
        if(!bundle.isEmpty())
        {
            order = (Order) bundle.get("order");

        }

    }

    private void setData()
    {
        Mtlob.setText(" طلب من " +order.getName());
        Date.setText(order.getDate());
        Price.setText(order.getPrice()+ "ريال" );
        Details.setText(order.getDescription());
        date.setText(order.getDate());
        Picasso.with(this).load(order.getImage()).into(Image);

    }


}
