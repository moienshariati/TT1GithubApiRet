package com.example.tt1githubapiret;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowGitResult extends AppCompatActivity {

    private TextView mtv_github,mtv_sholocation,mtv_shousername,mtv_shocomapny,mtv_shoemail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_git_result);

        mtv_github = findViewById(R.id.tv_github);
        mtv_shousername = findViewById(R.id.tv_userlocation);
        mtv_shocomapny = findViewById(R.id.tv_shocompany);
        mtv_shoemail = findViewById(R.id.tv_shoemail);
        mtv_sholocation = findViewById(R.id.tv_sholocation);

      showApiResult();
    }

    public void showApiResult(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GithubInterfaceC githubInterfaceC = retrofit.create(GithubInterfaceC.class);
        githubInterfaceC.getGithubUser().enqueue(new Callback<Github>() {
            @Override
            public void onResponse(Call<Github> call, Response<Github> response) {
                mtv_github.setText(response.body().toString());
                mtv_shousername.setText(response.body().getLogin());
                mtv_shocomapny.setText(response.body().getCompany());
                mtv_sholocation.setText(response.body().getLocation());
                mtv_shoemail.setText(response.body().getBio());

            }

            @Override
            public void onFailure(Call<Github> call, Throwable t) {

            }
        });
    }

}
