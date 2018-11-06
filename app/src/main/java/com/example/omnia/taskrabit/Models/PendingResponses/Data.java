package com.example.omnia.taskrabit.Models.PendingResponses;

/**
 * Created by Omnia on 11/6/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("orders")
    @Expose
    private List<Order> orders = null;
    @SerializedName("paginate")
    @Expose
    private Paginate paginate;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public Paginate getPaginate() {
        return paginate;
    }

    public void setPaginate(Paginate paginate) {
        this.paginate = paginate;
    }

}

