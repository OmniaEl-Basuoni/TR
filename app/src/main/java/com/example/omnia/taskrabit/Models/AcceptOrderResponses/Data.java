package com.example.omnia.taskrabit.Models.AcceptOrderResponses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("order_id")
    @Expose
    private String orderId;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

}