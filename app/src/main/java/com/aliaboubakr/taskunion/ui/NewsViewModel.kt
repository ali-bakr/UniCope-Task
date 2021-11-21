package com.aliaboubakr.taskunion.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aliaboubakr.taskunion.models.NewsResponseX
import com.aliaboubakr.taskunion.repository.NewsRepository
import com.aliaboubakr.taskunion.util.Resource
import kotlinx.coroutines.launch
import retrofit2.Response

class NewsViewModel(
    val newsReposatory: NewsRepository
): ViewModel(){

    val breakingNews: MutableLiveData<Resource<NewsResponseX>> = MutableLiveData()
    val breakingNewsPage=1

    init {
        getBreakingNews()
    }

    fun getBreakingNews()=viewModelScope.launch {
        breakingNews.postValue(Resource.Loading())
        val response=newsReposatory.getBreakingNews()

        breakingNews.postValue(handleBreakingNewsResponse(response))
    }

    fun handleBreakingNewsResponse(response:Response<NewsResponseX>):Resource<NewsResponseX>{
        if (response.isSuccessful){
            response.body()?.let { resultResponse ->
                return Resource.Success(resultResponse)
            }
        }

        return Resource.Error(response.message())
    }
}