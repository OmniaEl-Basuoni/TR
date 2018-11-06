package com.example.omnia.taskrabit.Models.LocationsResponses;

/**
 * Created by Omnia on 11/5/2018.
 */

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LocationResponse {

    @SerializedName("value")
    @Expose
    private Boolean value;
    @SerializedName("data")
    @Expose
    private List<LocationData> data = null;

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }

    public List<LocationData> getData() {
        return data;
    }

    public void setData(List<LocationData> data) {
        this.data = data;
    }


}