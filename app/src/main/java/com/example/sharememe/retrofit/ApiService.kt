package com.example.sharememe.retrofit

import com.example.sharememe.retrofit.model.MemeResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    // This method returns a Call object with a generic
    // type of DataModel, which represents
    // the data model for the response.
    @GET("get_memes")
    fun getJokes(): Call<MemeResponse>
}