package com.example.omnia.taskrabit.Remote;

import com.example.omnia.taskrabit.Models.FinishedResponses.FinishedResponse;
import com.example.omnia.taskrabit.Models.LocationsResponses.CitiesResponse;
import com.example.omnia.taskrabit.Models.LocationsResponses.LocationResponse;
import com.example.omnia.taskrabit.Models.LoginResponses.LoginResponse;
import com.example.omnia.taskrabit.Models.LogoutResponses.LogoutResponse;
import com.example.omnia.taskrabit.Models.PendingResponses.PendingResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UserService {

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("auth/login/tasker") Call<LoginResponse> Login(
            @Header("X-localization") String Localization,
            @Query("email") String email,
            @Query("password") String password
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("auth/register/tasker") Call<LoginResponse> Register(

    );




    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("locations/countries") Call<LocationResponse> Locations(
            @Header("X-localization") String Localization
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("user/logout") Call<LogoutResponse> Logouts(
            @Header("Authorization") String Authorization
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("locations/cities/{id}") Call<CitiesResponse> Cities(
            @Header("X-localization") String Localization,
            @Path("id") int id
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("orders/status/pending/{id}") Call<PendingResponse> Pending(
            @Header("Authorization") String Authorization,
                                    @Path("id") int id
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("orders/status/accepted/{id}") Call<PendingResponse> Accept(
            @Header("Authorization") String Authorization,
            @Path("id") int id
    );

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("orders/status/finished/{id}") Call<FinishedResponse> Finished(
            @Header("Authorization") String Authorization,
                        @Path("id") int id


    );


/*
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("home/sub_categories/{id}") Call<SubCategoryResponse> SubCategory(
            @Header("Authorization") String Authorization,
            @Path("id") int id,
            @Query("page") int page
    );*/






}
