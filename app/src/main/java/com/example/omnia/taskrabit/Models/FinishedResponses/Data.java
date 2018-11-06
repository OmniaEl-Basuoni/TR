package com.example.omnia.taskrabit.Models.FinishedResponses;

/**
 * Created by Omnia on 11/5/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("orders")
    @Expose
    private List<Object> orders = null;
    @SerializedName("paginate")
    @Expose
    private Paginate paginate;

    public List<Object> getOrders() {
        return orders;
    }

    public void setOrders(List<Object> orders) {
        this.orders = orders;
    }

    public Paginate getPaginate() {
        return paginate;
    }

    public void setPaginate(Paginate paginate) {
        this.paginate = paginate;
    }

}
