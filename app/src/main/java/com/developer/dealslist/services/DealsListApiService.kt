package com.developer.dealslist.services

import com.developer.dealslist.model.ListingItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://fetch-hiring.s3.amazonaws.com/"
const val END_POINT = "hiring.json"

private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val fetchService = retrofit.create(DealsListApiService::class.java)

/**
 * Service for fetching the remote data list
 **/
interface DealsListApiService{
    @GET(END_POINT)
    suspend fun getListItems(): MutableList<ListingItem>
}