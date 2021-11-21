package com.aliaboubakr.taskunion.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aliaboubakr.taskunion.repository.NewsRepository

class NewsViewModelProviderFactory(
    val newsRepository:NewsRepository
): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NewsViewModel(newsRepository)as T
    }
}