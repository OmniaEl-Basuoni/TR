package com.example.omnia.taskrabit.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Omnia on 11/5/2018.
 */

public class hgj {

    /**
     * value : true
     * data : {"id":4,"name":"Mostafa","email":"moustafa@gmail.com","phone":"01155276586","role":"tasker","is_verified":"0","image":"http://craft.panorama-alqassim.com/storage/","info":"Description About Me","card_no":"541232136","card_name":"Moustafa Mahmoud Aboelnaga","card_ccv":"961","city_id":"1","city_name":"القاهره","country_name":"مصر","services":[{"id":1,"sub_category_id":"1","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:40","updated_at":"2018-11-04 01:58:40"},{"id":2,"sub_category_id":"2","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:41","updated_at":"2018-11-04 01:58:41"},{"id":3,"sub_category_id":"3","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:41","updated_at":"2018-11-04 01:58:41"}],"vehicles":[],"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9jcmFmdC5wYW5vcmFtYS1hbHFhc3NpbS5jb21cL2FwaVwvYXV0aFwvbG9naW5cL3Rhc2tlciIsImlhdCI6MTU0MTQyNDM3NCwiZXhwIjoxNTQyNjMzOTc0LCJuYmYiOjE1NDE0MjQzNzQsImp0aSI6ImhQTnYyVFVNUDBLdjh6dkYiLCJzdWIiOjQsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.P69RhWBktXCC9lNeyMeWjWLi8l_IDhgIwtqsgP2o7fw"}
     */

    @SerializedName("value")
    private boolean value;
    @SerializedName("data")
    private DataBean data;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 4
         * name : Mostafa
         * email : moustafa@gmail.com
         * phone : 01155276586
         * role : tasker
         * is_verified : 0
         * image : http://craft.panorama-alqassim.com/storage/
         * info : Description About Me
         * card_no : 541232136
         * card_name : Moustafa Mahmoud Aboelnaga
         * card_ccv : 961
         * city_id : 1
         * city_name : القاهره
         * country_name : مصر
         * services : [{"id":1,"sub_category_id":"1","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:40","updated_at":"2018-11-04 01:58:40"},{"id":2,"sub_category_id":"2","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:41","updated_at":"2018-11-04 01:58:41"},{"id":3,"sub_category_id":"3","user_id":"4","price":"30","tools":"أدوات العمل متاحة","days":"3","hours":"12","created_at":"2018-11-04 01:58:41","updated_at":"2018-11-04 01:58:41"}]
         * vehicles : []
         * token : eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC9jcmFmdC5wYW5vcmFtYS1hbHFhc3NpbS5jb21cL2FwaVwvYXV0aFwvbG9naW5cL3Rhc2tlciIsImlhdCI6MTU0MTQyNDM3NCwiZXhwIjoxNTQyNjMzOTc0LCJuYmYiOjE1NDE0MjQzNzQsImp0aSI6ImhQTnYyVFVNUDBLdjh6dkYiLCJzdWIiOjQsInBydiI6Ijg3ZTBhZjFlZjlmZDE1ODEyZmRlYzk3MTUzYTE0ZTBiMDQ3NTQ2YWEifQ.P69RhWBktXCC9lNeyMeWjWLi8l_IDhgIwtqsgP2o7fw
         */

        @SerializedName("id")
        private int id;
        @SerializedName("name")
        private String name;
        @SerializedName("email")
        private String email;
        @SerializedName("phone")
        private String phone;
        @SerializedName("role")
        private String role;
        @SerializedName("is_verified")
        private String isVerified;
        @SerializedName("image")
        private String image;
        @SerializedName("info")
        private String info;
        @SerializedName("card_no")
        private String cardNo;
        @SerializedName("card_name")
        private String cardName;
        @SerializedName("card_ccv")
        private String cardCcv;
        @SerializedName("city_id")
        private String cityId;
        @SerializedName("city_name")
        private String cityName;
        @SerializedName("country_name")
        private String countryName;
        @SerializedName("token")
        private String token;
        @SerializedName("services")
        private List<ServicesBean> services;
        @SerializedName("vehicles")
        private List<?> vehicles;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getIsVerified() {
            return isVerified;
        }

        public void setIsVerified(String isVerified) {
            this.isVerified = isVerified;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getCardNo() {
            return cardNo;
        }

        public void setCardNo(String cardNo) {
            this.cardNo = cardNo;
        }

        public String getCardName() {
            return cardName;
        }

        public void setCardName(String cardName) {
            this.cardName = cardName;
        }

        public String getCardCcv() {
            return cardCcv;
        }

        public void setCardCcv(String cardCcv) {
            this.cardCcv = cardCcv;
        }

        public String getCityId() {
            return cityId;
        }

        public void setCityId(String cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public String getCountryName() {
            return countryName;
        }

        public void setCountryName(String countryName) {
            this.countryName = countryName;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public List<ServicesBean> getServices() {
            return services;
        }

        public void setServices(List<ServicesBean> services) {
            this.services = services;
        }

        public List<?> getVehicles() {
            return vehicles;
        }

        public void setVehicles(List<?> vehicles) {
            this.vehicles = vehicles;
        }

        public static class ServicesBean {
            /**
             * id : 1
             * sub_category_id : 1
             * user_id : 4
             * price : 30
             * tools : أدوات العمل متاحة
             * days : 3
             * hours : 12
             * created_at : 2018-11-04 01:58:40
             * updated_at : 2018-11-04 01:58:40
             */

            @SerializedName("id")
            private int id;
            @SerializedName("sub_category_id")
            private String subCategoryId;
            @SerializedName("user_id")
            private String userId;
            @SerializedName("price")
            private String price;
            @SerializedName("tools")
            private String tools;
            @SerializedName("days")
            private String days;
            @SerializedName("hours")
            private String hours;
            @SerializedName("created_at")
            private String createdAt;
            @SerializedName("updated_at")
            private String updatedAt;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getSubCategoryId() {
                return subCategoryId;
            }

            public void setSubCategoryId(String subCategoryId) {
                this.subCategoryId = subCategoryId;
            }

            public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getTools() {
                return tools;
            }

            public void setTools(String tools) {
                this.tools = tools;
            }

            public String getDays() {
                return days;
            }

            public void setDays(String days) {
                this.days = days;
            }

            public String getHours() {
                return hours;
            }

            public void setHours(String hours) {
                this.hours = hours;
            }

            public String getCreatedAt() {
                return createdAt;
            }

            public void setCreatedAt(String createdAt) {
                this.createdAt = createdAt;
            }

            public String getUpdatedAt() {
                return updatedAt;
            }

            public void setUpdatedAt(String updatedAt) {
                this.updatedAt = updatedAt;
            }
        }
    }
}
