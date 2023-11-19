package com.example.sharememe.retrofit.model

import com.google.gson.annotations.SerializedName

data class MemeResponse(

    @SerializedName("success") var success: Boolean? = null,
    @SerializedName("data") var data: Data? = Data()

)

data class Data(

    @SerializedName("memes") var memes: ArrayList<Memes> = arrayListOf()

)

data class Memes(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("url") var url: String? = null,
    @SerializedName("width") var width: Int? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("box_count") var boxCount: Int? = null,
    @SerializedName("captions") var captions: Int? = null

)