package com.example.mvpapp.scheduler

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
/**
 * Implementation of [IScheduler] with actual threads.
 * */
class AppScheduler : IScheduler {

    override fun mainThread(): io.reactivex.Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun io(): io.reactivex.Scheduler {
        return Schedulers.io()
    }
}