package com.example.qiitaapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.qiitaapp.View.ArticleView
import com.example.qiitaapp.model.Article
import com.example.qiitaapp.model.User

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listAdapter = ArticleListAdapter(applicationContext)
        listAdapter.articles = listOf(
            dummyArticle(title = "kotlin", userName = "Taro"),
            dummyArticle(title = "java", userName = "Jiro"))
//        val articleView = ArticleView(applicationContext)

        val listView: ListView = findViewById(R.id.list_view) as ListView
        listView.adapter = listAdapter

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
