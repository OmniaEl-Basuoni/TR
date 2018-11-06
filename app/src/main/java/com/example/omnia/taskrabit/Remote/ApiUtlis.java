package com.example.omnia.taskrabit.Remote;

public class ApiUtlis {

    public static final String Base_Url="http://craft.panorama-alqassim.com/api/";


    public static UserService getUserService()
    {
        return RetrofitClient.getClient(Base_Url).create(UserService.class);
    }
}
