package com.example.qiitaapp.View

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import com.example.qiitaapp.R
import com.example.qiitaapp.model.Article

/*
* カスタムビュー
* FrameLayoutを継承する
*
* */
class ArticleView : FrameLayout{

    // FrameLayoutは複数のコンストラクタを持っているのでセカンダリコンストラクタを使用する
    constructor(context : Context?)  : super(context)

    constructor(context: Context?,
                attrs : AttributeSet?) : super(context, attrs)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    constructor(context: Context?,
                attrs: AttributeSet?,
                defStyleAttr: Int,
                defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes)

    var profileImageView : ImageView? = null

    var titleTextView: TextView? = null

    var userNameTextView: TextView? = null


    /*
     * オブジェクトの初期化
     * ① R.layout.view_articleをAndroidのAPIを用いてインフレームしている
     * ② 対応するIDのViewを取得して各プロパティにセットする
     */
    init {
        LayoutInflater.from(context).inflate(R.layout.view_article, this) // ①
        profileImageView = findViewById(R.id.profile_image_view) as ImageView // ②
        titleTextView = findViewById(R.id.title_text_view) as TextView
        userNameTextView = findViewById(R.id.user_name_text_view) as TextView
    }

    /*
    * このクラスの使用側から記事オブジェクトをセットするためのメソッド
    * 各viewに記事データをセットして画面に反映する
    */
    fun setArticle(article: Article) {
        titleTextView?.text = article.title
        userNameTextView?.text = article.user.name
        profileImageView?.setBackgroundColor(Color.RED)
    }
}