package com.example.examenparcial;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface webServiceAPI {
    @GET("albums")
    Call<List<User>> getUsers();


}
