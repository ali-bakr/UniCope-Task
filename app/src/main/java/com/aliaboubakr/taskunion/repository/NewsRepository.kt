package com.aliaboubakr.taskunion.repository


import com.aliaboubakr.taskunion.api.RetrofitInstance



class NewsRepository(
) {
    suspend fun getBreakingNews(section:String,period:String)=
       RetrofitInstance.api.getBreakingNews(section,period)
}