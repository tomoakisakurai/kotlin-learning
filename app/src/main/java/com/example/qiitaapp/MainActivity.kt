package com.example.qiitaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import com.example.qiitaapp.View.ArticleView
import com.example.qiitaapp.client.ArticleClient
import com.example.qiitaapp.model.Article
import com.example.qiitaapp.model.User
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
//        listAdapter.articles = listOf(
//            dummyArticle(title = "kotlin", userName = "Taro"),
//            dummyArticle(title = "java", userName = "Jiro"))
////        val articleView = ArticleView(applicationContext)
//
//        val listView: ListView = findViewById(R.id.list_view) as ListView
//        listView.adapter = listAdapter


        val gson = GsonBuilder()
            .setFieldNamingPolicy(
                FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES
            ).create()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://qiita.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build()

        val articleClient = retrofit.create(ArticleClient::class.java)


        articleClient.search("kotlin")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                ""
                listAdapter.articles = it
                listAdapter.notifyDataSetChanged()
            }, {
                Toast.makeText(this, "error", Toast.LENGTH_LONG).show()
            })
//        articleView.setArticle(Article(id = "123",
//            title = "kotlin入門",
//            url = "http://www",
//            user = User(
//                id = "456",
//                name = "Taro",
//                profileImageUrl = ""
//            )))

    }


    private fun dummyArticle(title: String, userName: String): Article =
        Article(id = "", title = title, url = "", user = User(id = "", name = userName, profileImageUrl = " "))

}
