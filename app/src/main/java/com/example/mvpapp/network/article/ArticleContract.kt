package com.example.mvpapp.network.article

import com.example.mvpapp.MainActivity
import com.example.mvpapp.model.Results

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
val articleContractView by lazy { MainActivity() }

 interface ArticleContract {
    interface View {
        fun showArticleList(results: List<Results>?)
//        fun showArticleList(items: List<Results>)
//        fun articleClicked(itemClicked: Results)

    }

    interface Presenter {
        fun fetchArticles()
        fun setView(mainActivity: MainActivity)
    }
}