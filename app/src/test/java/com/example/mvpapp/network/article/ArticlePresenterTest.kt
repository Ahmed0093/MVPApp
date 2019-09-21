package com.example.mvpapp.network.article

import android.content.Context
import com.example.mvpapp.model.ApiResponse
import com.example.mvpapp.model.Results
import com.example.mvpapp.network.DomainIntegration
import com.example.mvpapp.network.NetworkModule
import com.example.mvpapp.scheduler.TestScheduler

import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Test

import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations
import java.io.IOException

/**
 * Created by Ahmed Abdullah on 9/21/2019.
 */
@RunWith(JUnit4::class)
class ArticlePresenterTest {

    private lateinit var articlePresenter: ArticlePresenter

    @Mock
    lateinit var articleView: ArticleContract.View
    @Mock
    lateinit var disposables: CompositeDisposable
    @Mock
    lateinit var apiHelper: NetworkModule

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        val context = mock(Context::class.java)
        DomainIntegration.withContext(context)
        articlePresenter = ArticlePresenter(articleView, TestScheduler(), disposables, apiHelper)
    }

    @Test
    fun onDestroyCalled() {
        articlePresenter.onDestroyCalled()
        verify(disposables).clear()
    }

    @Test
    fun fetchArticles() {

        `when`(apiHelper.provideArticleApi())
            .thenReturn(Observable.just(getDummyApiResponseResult()))


        articlePresenter.fetchArticles()
        verify(articleView).showArticleList(getDummyApiResponseResult().results)

    }

    @Test
    fun fetchArticles_Error() {

        `when`(apiHelper.provideArticleApi())
            .thenReturn(Observable.error(IOException()))


        articlePresenter.fetchArticles()
        verifyNoMoreInteractions(articleView)

    }

    @Test
    fun onArticleItemCLicked() {
        articlePresenter.onArticleItemCLicked(getDummyResultList().get(0))
        verify(articleView).navigateToDetailsActivity(getDummyResultList().get(0))
    }

    fun getDummyResultList(): List<Results> {
        val results: ArrayList<Results> = ArrayList()

        val result2: Results = Results(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            3,
            2,
            1,
            null,
            null,
            null,
            null,
            emptyList(),
            ""
        )

        results.add(result2)
        return results
    }

    fun getDummyApiResponseResult(): ApiResponse {
        val results: ArrayList<Results> = ArrayList()
        val result2: Results = Results(
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            3,
            2,
            1,
            null,
            null,
            null,
            null,
            emptyList(),
            ""
        )
        results.add(result2)
        val apiResponse: ApiResponse = ApiResponse("", "", 3, results)
        return apiResponse
    }

}