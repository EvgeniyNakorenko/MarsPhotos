package com.example.m17_recyclerview.data

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import javax.inject.Inject

private const val BASE_API =
    "https://api.nasa.gov/mars-photos/"

class PhotosRepository @Inject constructor() {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_API)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val searchIPI: SearchAPI = retrofit.create(SearchAPI::class.java)

    interface SearchAPI {
        @Headers(
            "Accept: application/json",
            "Content-type: application/json"
        )
        @GET(
            "api/v1/rovers/curiosity/photos?sol=1000&page=2&api_key=ASxVsFXzQeOCXfZcXKZhqa3qveeCr4htScNqx9Dn"
        )
        suspend fun getPhotos(): Response<PhotosResponse>
    }

}