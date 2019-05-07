package com.example.qiitaapp.client

import com.example.qiitaapp.model.Article
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ArticleClient {

    // Observable RxAndroidが提供するクラス
    // 結果はList<Article>となる
    @GET("/api/v2/items")
    fun search(@Query("query") query: String): Observable<List<Article>>

}