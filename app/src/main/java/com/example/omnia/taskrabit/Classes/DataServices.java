package com.example.omnia.taskrabit.Classes;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DataServices implements Serializable {
    @SerializedName("sub_category_id")
    @Expose
    private String subCategoryId;
    @SerializedName("price")
    @Expose
    private Integer price;
    @SerializedName("tools")
    @Expose
    private String tools;
    @SerializedName("days")
    @Expose
    private Integer days;
    @SerializedName("hours")
    @Expose
    private Integer hours;

    public String getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(String subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTools() {
        return tools;
    }

    public void setTools(String tools) {
        this.tools = tools;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

}
