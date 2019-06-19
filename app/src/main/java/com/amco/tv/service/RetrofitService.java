package com.amco.tv.service;


import com.amco.tv.model.cast.Cast;
import com.amco.tv.model.program.Program;
import com.amco.tv.model.programs.Programs;
import com.amco.tv.tools.ListListener;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author isaicastro
 */

public interface RetrofitService {

    public static String BASE_URL = "http://api.tvmaze.com/";

    @GET("schedule")
    Call<List<Programs>> getProgramsList(@Query("country") String country, @Query("date") String date);

    @GET("shows/{programId}")
    Call<Program> getProgram(@Path("programId") String programId);

    @GET("shows/{programId}/cast")
    Call<List<Cast>> getProgramCast(@Path("programId") String programId);
}