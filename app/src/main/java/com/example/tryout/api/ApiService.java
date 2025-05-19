package com.example.tryout.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import com.example.tryout.model.Ayah;
import com.example.tryout.model.AyahResponses;
import com.example.tryout.model.Surah;

import java.util.List;

public interface ApiService {
    @GET("surahs")
    Call<List<Surah>> getSurahs();
    @GET("surahs/{number}")
    Call<AyahResponses> getAyahs(@Path("number") int number);

}
