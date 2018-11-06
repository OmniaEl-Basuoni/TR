package com.example.omnia.taskrabit.Models.RegisterResponses;

/**
 * Created by Omnia on 11/6/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("msg")
    @Expose
    private String msg;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}