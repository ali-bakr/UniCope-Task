package com.aliaboubakr.taskunion.repository


import com.aliaboubakr.taskunion.api.RetrofitInstance



class NewsRepository(
) {
    suspend fun getBreakingNews()=
       RetrofitInstance.api.getBreakingNews()
}