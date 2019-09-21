package com.example.mvpapp

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpapp.adapter.Adapter2
import com.example.mvpapp.adapter.ArticleListAdapter
import com.example.mvpapp.model.ApiResponse
import com.example.mvpapp.model.Results
import com.example.mvpapp.network.Api
import com.example.mvpapp.network.DomainIntegration
import com.example.mvpapp.network.article.ArticleContract
import com.example.mvpapp.network.article.articlePresenter
import com.example.mvpapp.network.networkModule
import com.example.mvpapp.scheduler.performOnBackGroundOutOnMainThread
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , ArticleContract.View, Adapter2.OnMovieClicked {
    override fun onClick(Results: Results) {
        Toast.makeText(DomainIntegration.getContext(),"itemid=",Toast.LENGTH_LONG).show()
    }

    lateinit var adapter: ArticleListAdapter
    private lateinit var mRecyclerView: RecyclerView

    private lateinit var mMoviesAdapter: Adapter2
    var disposables : CompositeDisposable? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        disposables = CompositeDisposable()
        articlePresenter.setView(this)
        DomainIntegration.withContext(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.rvPosts)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mMoviesAdapter = Adapter2(this,this)
        mRecyclerView.adapter = mMoviesAdapter
        articlePresenter.fetchArticles()
//        disposables?.add(
//            networkModule.providesRetrofit().create(Api::class.java).getArticles()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({respone: ApiResponse? ->
//                    respone?.results?.let { mMoviesAdapter.setData(it) }
//                    Log.d("API",respone.toString())},
//                    { error ->  Log.d("Error",error.toString()) }))

//        mMoviesAdapter.setData(getDummyResultList())

    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this@MainActivity, "open", Toast.LENGTH_SHORT).show()
//        adapter = ArticleListAdapter { item ->
//            Toast.makeText(DomainIntegration.getContext(),"itemid="+item.id,Toast.LENGTH_LONG).show()
//        }
//        adapter?.setArticles(mutableListOf())
//        recycler_list.adapter = adapter
//        DomainIntegration.withContext(this)
     //   articlePresenter.fetchArticles()


    }

    override fun onDestroy() {
        super.onDestroy()
        articlePresenter.onDestroyCalled()
        disposables?.clear()
    }

    fun getDummyResultList(): List<Results> {
         var results: ArrayList<Results> = ArrayList()
         var result1: Results = Results()
         var result2: Results = Results()

         results.add(result1)
         results.add(result2)
         return results
     }

    override fun showArticleList(results: List<Results>?) {
        Log.d("+++++++","Show Atil")
        results?.let { mMoviesAdapter.setData(it) }
    }

}
