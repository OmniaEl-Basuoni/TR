package com.example.omnia.taskrabit.Models.VechileResponses;

/**
 * Created by Omnia on 11/7/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VechileResponse {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private List<Datum> data = null;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

}