package com.example.sharememe.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.example.sharememe.retrofit.ApiService
import com.example.sharememe.retrofit.model.MemeResponse
import com.example.sharememe.retrofit.model.Memes
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainRepository {

    companion object {


        // This function takes a Context and callback function
        // as a parameter, which will be called
        // when the API response is received.
        fun getJokes(context: Context): List<Memes> {

            val imageList = ArrayList<Memes>()
            // Create a Retrofit instance with the base URL and
            // a GsonConverterFactory for parsing the response.
            val retrofit: Retrofit =
                Retrofit.Builder().baseUrl("https://api.imgflip.com/").addConverterFactory(
                    GsonConverterFactory.create()
                ).build()

            // Create an ApiService instance from the Retrofit instance.
            val service: ApiService = retrofit.create<ApiService>(ApiService::class.java)

            // Call the getjokes() method of the ApiService
            // to make an API request.
            val call: Call<MemeResponse> = service.getJokes()

            // Use the enqueue() method of the Call object to
            // make an asynchronous API request.
            call.enqueue(object : Callback<MemeResponse> {

                override fun onResponse(
                    call: Call<MemeResponse>?,
                    response: retrofit2.Response<MemeResponse>?
                ) {
                    if (response!!.isSuccessful) {
                        // If the response is successful, parse the
                        // response body to a MemeResponse object.
                        val jokes: MemeResponse = response.body() as MemeResponse

                        // Call the callback function with the MemeResponse
                        // object as a parameter.
                        //  callback(jokes)

                        val imageCount = jokes.data?.memes?.size

                        for (i in 0..10) {
                            imageList.add(jokes.data!!.memes[i])
                        }
                        Log.e("ALL_MEMES", imageList.toString())
                    }
                }

                override fun onFailure(call: Call<MemeResponse>?, t: Throwable?) {
                    Toast.makeText(context, "Request Fail", Toast.LENGTH_SHORT).show()
                }
            })


            return imageList
        }
    }
}