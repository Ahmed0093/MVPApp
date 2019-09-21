package com.example.mvpapp

import android.app.Application
import android.content.Context
import com.example.mvpapp.network.DomainIntegration

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
class MyApplicatian : Application() {

    override fun onCreate() {
        super.onCreate()
//        DomainIntegration.with(this)
    }

}