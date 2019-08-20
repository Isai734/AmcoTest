package com.amco.tv.service;


import com.amco.tv.model.MoviesRate;
import com.amco.tv.tools.ListListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author isaicastro
 */

public interface RetrofitService {

    String BASE_URL = "https://api.themoviedb.org/3/";

    @GET("movie/top_rated")
    @Headers("Accept: application/json")
    Call<MoviesRate> getMoviesRate(@Query("api_key") String api_key, @Query("language") String language);
}