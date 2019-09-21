package com.example.mvpapp.network.article

import android.util.Log
import com.example.mvpapp.MainActivity
import com.example.mvpapp.model.ApiResponse
import com.example.mvpapp.network.Api
import com.example.mvpapp.network.NetworkModule
import com.example.mvpapp.network.networkModule
import com.example.mvpapp.scheduler.IScheduler
import com.example.mvpapp.scheduler.appScheduler
import com.example.mvpapp.scheduler.performOnBack
import com.example.mvpapp.scheduler.performOnBackGroundOutOnMainThread
import io.reactivex.disposables.CompositeDisposable
import retrofit2.Call
import java.util.*

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
val articlePresenter by lazy { ArticlePresenter() }

class ArticlePresenter(
    var articleView: ArticleContract.View = articleContractView, val scheduler:IScheduler = appScheduler, val  disposables :CompositeDisposable = CompositeDisposable()
    , apiHelper: NetworkModule = networkModule
)  :ArticleContract.Presenter {
    override fun setView(mainActivity: MainActivity) {
        articleView = mainActivity
    }


    override fun fetchArticles() {
        disposables.add(networkModule.providesRetrofit().create(Api::class.java).getArticles()
            .performOnBackGroundOutOnMainThread(scheduler)
            .subscribe({respone: ApiResponse? ->
                articleView.showArticleList(respone?.results)
                Log.d("API",respone.toString())},
                { error ->  Log.d("Error",error.toString()) }))
    }

    fun onDestroyCalled() {
        disposables.clear()
    }

}




