package com.example.restapi_retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("posts/id")
    public Call<Post> getPost(@Path("id") int postid);

    @POST("posts")
    public Call<Post> storePost(@Body Post post);

}
