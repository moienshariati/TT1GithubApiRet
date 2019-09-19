package com.example.tt1githubapiret;


import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubInterfaceC {


    @GET("users/moienshariati")
    Call<Github> getGithubUser();
}
