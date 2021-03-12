package com.example.restapi_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {

    TextView PostTitleTV;
    TextView PostBodyTV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Post post = new Post(5,"CODEDEV", "Hello World");

        PostTitleTV = findViewById(R.id.post_title_tv);
        PostBodyTV = findViewById(R.id.post_body_tv);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create())
                .build();


        ApiInterface apiInterface = retrofit.create(ApiInterface.class);


        Call<Post> call = apiInterface.storePost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                PostTitleTV.setText(response.body().getTitle());
                PostBodyTV.setText(response.body().getBody());
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                PostTitleTV.setText(t.getMessage());
                PostBodyTV.setText(t.getMessage());
            }
        });


    }
}