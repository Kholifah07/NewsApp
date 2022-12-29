package com.kadirkuruca.newsapp.data.remote

import com.kadirkuruca.newsapp.data.model.NewsResponse
import com.kadirkuruca.newsapp.util.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
//calss interface
interface NewsApi {
    //diguanakan utuk mendapatkan "v2/top-heandlines
    @GET("v2/top-headlines")
    suspend fun getBreakingNews(
        @Query("country") countryCode: String = "tr",
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>
    //diguanakan utuk mendapatkan "v2/everything
    @GET("v2/everything")
    suspend fun searchForNews(
        @Query("q") searchQuery: String,
        @Query("page") pageNumber: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): Response<NewsResponse>

}