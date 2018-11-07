package com.example.omnia.taskrabit.Models.LoginResponses;

/**
 * Created by Omnia on 11/5/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    @SerializedName("msg")
    @Expose
    private String msg;
    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private DataUser data;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public DataUser getData() {
        return data;
    }

    public void setData(DataUser data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}