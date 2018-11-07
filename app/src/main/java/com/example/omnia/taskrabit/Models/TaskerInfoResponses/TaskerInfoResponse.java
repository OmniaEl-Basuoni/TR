package com.example.omnia.taskrabit.Models.TaskerInfoResponses;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskerInfoResponse {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private Data data;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

}