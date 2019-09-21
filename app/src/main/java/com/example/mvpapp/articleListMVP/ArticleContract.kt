package com.example.mvpapp.articleListMVP

import com.example.mvpapp.model.Results

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
val articleContractView by lazy { ArticleActivity() }

 interface ArticleContract {
    interface View {
        fun showArticleList(results: List<Results>?)
        fun navigateToDetailsActivity(results: Results)
//        fun showArticleList(items: List<Results>)
//        fun articleClicked(itemClicked: Results)

    }

    interface Presenter {
        fun fetchArticles()
        fun setView(mainActivity: ArticleActivity)
        fun onArticleItemCLicked(results: Results)
        fun onDestroyCalled()

    }
}