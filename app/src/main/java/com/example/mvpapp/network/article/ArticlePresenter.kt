package com.example.mvpapp.network.article

import android.util.Log
import com.example.mvpapp.MainActivity
import com.example.mvpapp.model.ApiResponse
import com.example.mvpapp.model.Results
import com.example.mvpapp.network.Api
import com.example.mvpapp.network.NetworkModule
import com.example.mvpapp.network.networkModule
import com.example.mvpapp.scheduler.IScheduler
import com.example.mvpapp.scheduler.appScheduler
import com.example.mvpapp.scheduler.performOnBackGroundOutOnMainThread
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
val articlePresenter by lazy { ArticlePresenter() }

class ArticlePresenter(
    var articleView: ArticleContract.View = articleContractView,
    val scheduler: IScheduler = appScheduler,
    val disposables: CompositeDisposable = CompositeDisposable(),
    val apiHelper: NetworkModule = networkModule
) : ArticleContract.Presenter {

    override fun setView(mainActivity: MainActivity) {
        articleView = mainActivity
    }

    override fun fetchArticles() {
        disposables.add(
            apiHelper.provideArticleApi()
                .performOnBackGroundOutOnMainThread(scheduler)
                .subscribe({ response: ApiResponse? ->
                    articleView.showArticleList(response?.results)
                    Log.d("API", response.toString())
                },
                    { error -> Log.d("Error", error.toString()) })
        )
    }

    override fun onDestroyCalled() {
        disposables.clear()
    }

    override fun onArticleItemCLicked(results: Results) {
        articleView.navigateToDetailsActivity(results)
    }

}




