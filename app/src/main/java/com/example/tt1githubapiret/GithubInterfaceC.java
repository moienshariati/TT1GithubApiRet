package com.example.tt1githubapiret;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GithubInterfaceC {


    @GET("users/moienshariati")
    Call<Github> getGithubUser();
}
