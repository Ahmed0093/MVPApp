package com.example.mvpapp.scheduler

import io.reactivex.Scheduler

/**
 * Created by Ahmed Abdullah on 9/20/2019.
 */
val appScheduler by lazy { (AppScheduler()) }

interface IScheduler {
    fun mainThread(): Scheduler
    fun io():Scheduler
}