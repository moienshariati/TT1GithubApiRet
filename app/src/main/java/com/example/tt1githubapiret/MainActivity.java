package com.example.tt1githubapiret;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mtv_github, mtv_sholocation, mtv_shousername, mtv_shocomapny, mtv_shoebio;
    private Button mbtn_show;
//    private FragmentShowApi fragmentShowApi = new FragmentShowApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        showApiResult();

        mbtn_show = findViewById(R.id.btn_show);

        mtv_github = findViewById(R.id.tv_github);
        mtv_shousername = findViewById(R.id.tv_shoname);
        mtv_shocomapny = findViewById(R.id.tv_shocompany);
        mtv_shoebio = findViewById(R.id.textview_bio);
        mtv_sholocation = findViewById(R.id.tv_sholocation);


        mbtn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isConnected()) {
                    Intent intent=new Intent(MainActivity.this,ShowGitResult.class);
                    startActivity(intent);
                    Toast.makeText(MainActivity.this, "Internet is Connected", Toast.LENGTH_SHORT).show();
//                    FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
//                    transaction.replace(R.id.fragment_holder, fragmentShowApi);
//                    transaction.commit();
                } else {
                    Toast.makeText(MainActivity.this, "No Internet Connection", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    //Check internet Connection
    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }

//    public void showApiResult() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.github.com/")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        GithubInterfaceC githubInterfaceC = retrofit.create(GithubInterfaceC.class);
//        githubInterfaceC.getGithubUser().enqueue(new Callback<Github>() {
//            @Override
//            public void onResponse(Call<Github> call, Response<Github> response) {
//
////                if (response != null) {
////                    Bundle bundle = new Bundle();
////                    bundle.putString("keygit", response.body().toString());
////                    bundle.putString("keyname", response.body().getLogin());
////                    bundle.putString("keycompany", response.body().getCompany());
////                    bundle.putString("keybio", response.body().getBio());
////                    bundle.putString("keylocation", response.body().getLocation());
////
////                    fragmentShowApi.setArguments(bundle);
////                }else{
////                    Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
////                }
//
//
//                mtv_github.setText(response.body().toString());
//                mtv_shousername.setText(response.body().getLogin());
//                mtv_shocomapny.setText(response.body().getCompany());
//                mtv_sholocation.setText(response.body().getLocation());
//                mtv_shoebio.setText(response.body().getBio());
//            }
//
//            @Override
//            public void onFailure(Call<Github> call, Throwable t) {
//
//            }
//        });
//    }
}
