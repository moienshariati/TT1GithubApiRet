package com.example.tt1githubapiret;

import androidx.appcompat.app.AppCompatActivity;


import android.app.Dialog;

import android.os.Bundle;

import android.widget.TextView;

import com.bumptech.glide.Glide;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowGitResult extends AppCompatActivity {


    Dialog progressDialog;
    CircleImageView imageView;

    private TextView mtv_github, mtv_sholocation, mtv_shousername, mtv_shocomapny, mtv_shobio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        progresShow();


        imageView = findViewById(R.id.imageView);
        mtv_github = findViewById(R.id.tv_github);
        mtv_shousername = findViewById(R.id.tv_shoname);
        mtv_shocomapny = findViewById(R.id.tv_shocompany);
        mtv_shobio = findViewById(R.id.textview_bio);
        mtv_sholocation = findViewById(R.id.tv_sholocation);


        showApiResult();
    }

    public void showApiResult() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubInterfaceC githubInterfaceC = retrofit.create(GithubInterfaceC.class);
        githubInterfaceC.getGithubUser().enqueue(new Callback<Github>() {

            public void onResponse(Call<Github> call, Response<Github> response) {
                Glide
                        .with(ShowGitResult.this)
                        .load(response.body().getAvatar_url())
                        .into(imageView);

                mtv_github.setText(response.body().toString());
                mtv_shousername.setText(response.body().getLogin());
                mtv_shocomapny.setText(response.body().getCompany());
                mtv_sholocation.setText(response.body().getLocation());
                mtv_shobio.setText(response.body().getBio());
//                imageView.setImageURI();
                progressDialog.dismiss();
//                notificationOnApiCall();
            }

            @Override
            public void onFailure(Call<Github> call, Throwable t) {

            }
        });
    }

    public void progresShow() {
        progressDialog = new Dialog(ShowGitResult.this);
        progressDialog.setContentView(R.layout.dailog_layout);
        progressDialog.setTitle("Please wait");

        progressDialog.show();

    }
}