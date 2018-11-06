package com.example.omnia.taskrabit.Models.CurrentResponses;

/**
 * Created by Omnia on 11/5/2018.
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("duration")
    @Expose
    private String duration;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("accepted_orders")
    @Expose
    private Integer acceptedOrders;
    @SerializedName("finished_orders")
    @Expose
    private Integer finishedOrders;
    @SerializedName("pending_orders")
    @Expose
    private Integer pendingOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAcceptedOrders() {
        return acceptedOrders;
    }

    public void setAcceptedOrders(Integer acceptedOrders) {
        this.acceptedOrders = acceptedOrders;
    }

    public Integer getFinishedOrders() {
        return finishedOrders;
    }

    public void setFinishedOrders(Integer finishedOrders) {
        this.finishedOrders = finishedOrders;
    }

    public Integer getPendingOrders() {
        return pendingOrders;
    }

    public void setPendingOrders(Integer pendingOrders) {
        this.pendingOrders = pendingOrders;
    }

}
