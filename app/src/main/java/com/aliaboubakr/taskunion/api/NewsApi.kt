package com.aliaboubakr.taskunion.api

import com.aliaboubakr.taskunion.models.NewsResponseX

import retrofit2.Response

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {

    @Headers(
        "App-Id:c5555ca5-304f-4f7a-918f-bc6963b55c5e"
        ,"Password:51Kjxaeudnnadb060520190ADMIN3360520190345@ucs.ae"
        ,"Content-Type:application/json"
        ,"Lang:en",
        "DeviceType:Android")

    @GET("mostviewed/all-sections/30.json?api-key=kjWL3IMsOTCUgfZWnsq9HJix6bGqMjGS")
    suspend fun getBreakingNews(

    ):Response<NewsResponseX>

}