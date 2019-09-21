package com.example.mvpapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mvpapp.adapter.ArticleAdapter
import com.example.mvpapp.adapter.ArticleListAdapter
import com.example.mvpapp.constants.Constants
import com.example.mvpapp.imagemodule.imageLoader
import com.example.mvpapp.model.Results
import com.example.mvpapp.network.DomainIntegration
import com.example.mvpapp.network.article.ArticleContract
import com.example.mvpapp.network.article.articlePresenter

class MainActivity : AppCompatActivity(), ArticleContract.View,
    ArticleAdapter.OnArticleItemClicked {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var articleAdapter: ArticleAdapter
    private val context: Context by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        articlePresenter.setView(this)
        DomainIntegration.withContext(context)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById(R.id.rvPosts)
        mRecyclerView.layoutManager = LinearLayoutManager(this)
        articleAdapter = ArticleAdapter(this, imageLoader = imageLoader)
        mRecyclerView.adapter = articleAdapter
        articlePresenter.fetchArticles()

    }

    override fun onDestroy() {
        super.onDestroy()
        articlePresenter.onDestroyCalled()
    }

    override fun showArticleList(results: List<Results>?) {
        results?.let { articleAdapter.setData(it) }
    }

    override fun navigateToDetailsActivity(results: Results) {
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra(Constants.SELECTED_Article, results)
        context.startActivity(intent)
    }

    override fun onClick(results: Results) {
        articlePresenter.onArticleItemCLicked(results)
    }

}
