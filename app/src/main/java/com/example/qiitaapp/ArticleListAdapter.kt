package com.example.qiitaapp

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.qiitaapp.View.ArticleView
import com.example.qiitaapp.model.Article

/*
* 記事リストadapter
* viewとデータの橋渡し
*
* */
class ArticleListAdapter(private val context: Context): BaseAdapter() {

    var articles: List<Article> = emptyList()

    override fun getCount(): Int = articles.size

    override fun getItem(position: Int): Any? = articles[position]

    override fun getItemId(position: Int): Long = 0

    override fun getView(position: Int,
                         convertView: View?,
                         parent: ViewGroup?): View =
        ((convertView as? ArticleView) ?: ArticleView(context = context)).apply {
            setArticle(articles[position]) // ArticleViewのsetArticleを呼び出して記事をセットしていいる。
        }
}