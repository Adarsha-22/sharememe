package com.example.sharememe.retrofit

import retrofit2.Retrofit

class RetrofitInstance {

    val baseUrl = "https://api.imgflip.com/"

    val api = Retrofit.Builder().baseUrl(baseUrl).build()
}