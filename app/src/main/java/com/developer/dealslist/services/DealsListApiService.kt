package com.developer.dealslist.services

import com.developer.dealslist.BuildConfig
import com.developer.dealslist.model.DealsList
import com.developer.dealslist.model.ListingItem
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

private const val BASE_URL = BuildConfig.BASE_URL
private const val END_POINT = BuildConfig.END_POINT

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

    /**
     * Gets the full list of deals
     */
    @GET(END_POINT)
    suspend fun getDealsListItems(): DealsList

    /**
     * Gets a single item details
     */
    @GET("${BASE_URL}${END_POINT}/{dealId}")
    suspend fun getSingleItem(@Path("dealId") dealId: String): ListingItem
}