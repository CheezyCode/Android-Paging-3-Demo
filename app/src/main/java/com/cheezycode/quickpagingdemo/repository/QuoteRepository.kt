package com.cheezycode.quickpagingdemo.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.cheezycode.quickpagingdemo.paging.QuotePagingSource
import com.cheezycode.quickpagingdemo.retrofit.QuoteAPI
import javax.inject.Inject

class QuoteRepository @Inject constructor(private val quoteAPI: QuoteAPI) {

    fun getQuotes() = Pager(
        config = PagingConfig(pageSize = 20, maxSize = 100),
        pagingSourceFactory = { QuotePagingSource(quoteAPI) }
    ).liveData
}