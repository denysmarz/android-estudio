package com.example.clas3;


import com.example.clas3.json.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface webServiceAPI {
    @GET("users")
    Call<List<User>> getUsers();
}
