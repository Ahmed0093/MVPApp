package com.example.mvpapp.network

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
object DomainIntegration {

    private lateinit var applicationReference : WeakReference<Application>
    private lateinit var context : WeakReference<Context>


    fun with(application: Application){
        applicationReference = WeakReference(application)
    }
    fun withContext(applicationContext: Context){
        context = WeakReference(applicationContext)
    }

    fun getApplication() = applicationReference.get()!!

    fun getContext() = context.get()!!

}